/*
 * REST APIに対してリクエストを行うことを想定したテストクラスです。
 * 
 * データストア（ここではインメモリ）に対して、HTTPリクエストを行います。
 */

package example.cashcard;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
// assertjはアサーション（検証用）ライブラリです
import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
// これにより、Spring Bootアプリケーションが起動され、テストがそれに対してリクエストを実行できるようになります。
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CashCardApplicationTests {

	// 自動化されたTestRestTemplate restTemplateです。
	// AutowiredはSpringの依存性注入の一形態ですが、テストでのみ使用するのがベストであることに注意してください。
	@Autowired
	TestRestTemplate restTemplate;

	/*
	 * GETリクエストテスト用クラス
	 * GETエンドポイントを作成しurlに指定したIDでGETリクエストのテストを実施します。
	 * このテストでは、インメモリに設定したIDを指定するため、responseとしてカード情報を取得できることが期待されます。
	 */
	@Test
	@DirtiesContext
	void shouldReturnACashCardWhenDataIsSaved() {
		// Basic Auth、urlとレスポンスを指定してGETリクエスト
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("sarah1", "abc123")
				.getForEntity("/cashcards/99", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		// レスポンスを、多くのヘルパーメソッドを持つ JSON 対応のオブジェクトに変換する
		// https://github.com/json-path/JsonPath
		DocumentContext documentContext = JsonPath.parse(response.getBody());
		Number id = documentContext.read("$.id");
		assertThat(id).isEqualTo(99);
		Double amount = documentContext.read("$.amount");
		assertThat(amount).isEqualTo(123.45);
	}

	/*
	 * GETリクエスト（LIST取得）用テストクラス
	 */
	@Test
	void shouldReturnAllCashCardsWhenListIsRequested() {
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("sarah1", "abc123")
				.getForEntity("/cashcards", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		// 配列の長さを計算する
		int cashCardCount = documentContext.read("$.length()");
		assertThat(cashCardCount).isEqualTo(3);
		// containsExactlyInAnyOrder()
		// リストには私たちが主張するものがすべて含まれていなければならないが、順番は関係ないことを表明しています。
		// 返されたすべての id 値のリストを取得する
		JSONArray ids = documentContext.read("$..id");
		assertThat(ids).containsExactlyInAnyOrder(99, 100, 101);
		// 返されたすべてのamountの値のリストを取得する
		JSONArray amounts = documentContext.read("$..amount");
		assertThat(amounts).containsExactlyInAnyOrder(123.45, 1.00, 150.00);
	}

	/*
	 * GETリクエスト（LIST取得 ページング実装）用テストクラス
	 */
	@Test
	void shouldReturnAPageOfCashCards() {
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("sarah1", "abc123")
				.getForEntity("/cashcards?page=0&size=1", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		JSONArray page = documentContext.read("$[*]");
		assertThat(page.size()).isEqualTo(1);
	}

	/*
	 * GETリクエスト（LIST取得 ソート実装）用テストクラス
	 */
	@Test
	void shouldReturnASortedPageOfCashCards() {
		// URIは、ページネーションとソートの両方の情報を含んでいます。
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("sarah1", "abc123")
				.getForEntity("/cashcards?page=0&size=1&sort=amount,desc", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		JSONArray read = documentContext.read("$[*]");
		assertThat(read.size()).isEqualTo(1);

		double amount = documentContext.read("$[0].amount");
		assertThat(amount).isEqualTo(150.00);
	}

	/*
	 * GETリクエスト（LIST取得 ソート実装）用テストクラス
	 * ページネーションやソートのパラメータを送信しない
	 */
	@Test
	void shouldReturnASortedPageOfCashCardsWithNoParametersAndUseDefaultValues() {
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("sarah1", "abc123")
				.getForEntity("/cashcards", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		JSONArray page = documentContext.read("$[*]");
		assertThat(page.size()).isEqualTo(3);

		JSONArray amounts = documentContext.read("$..amount");
		assertThat(amounts).containsExactly(1.00, 123.45, 150.00);
	}

	/*
	 * POSTリクエストテスト用クラス
	 */
	@Test
	@DirtiesContext
	void shouldCreateANewCashCard() {
		// id の指定は、既存のリソースに対してアップデートを実行する際にサポートされる
		// CashCard newCashCard = new CashCard(44L, 250.00);
		CashCard newCashCard = new CashCard(null, 250.00, null);
		ResponseEntity<Void> createResponse = restTemplate
				.withBasicAuth("sarah1", "abc123").postForEntity("/cashcards", newCashCard, Void.class);
		assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

		URI locationOfNewCashCard = createResponse.getHeaders().getLocation();
		ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewCashCard, String.class);
		assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
		Number id = documentContext.read("$.id");
		Double amount = documentContext.read("$.amount");

		assertThat(id).isNotNull();
		assertThat(amount).isEqualTo(250.00);
	}

	/*
	 * ベーシック認証で不正な認証情報が送信されたときに 401 UNAUTHORIZED レスポンスを期待するテスト
	 */
	@Test
	void shouldNotReturnACashCardWhenUsingBadCredentials() {
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("BAD-USER", "abc123")
				.getForEntity("/cashcards/99", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

		response = restTemplate
				.withBasicAuth("sarah1", "BAD-PASSWORD")
				.getForEntity("/cashcards/99", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}

	@Test
	void shouldRejectUsersWhoAreNotCardOwners() {
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("hank-owns-no-cards", "qrs456")
				.getForEntity("/cashcards/99", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
	}

	/*
	 * ユーザーが所有していないキャッシュカードにアクセスしようとすると、API が 404 NOT FOUND を返すことを明示的に保証するテストです
	 */
	@Test
	void shouldNotAllowAccessToCashCardsTheyDoNotOwn() {
		ResponseEntity<String> response = restTemplate
				.withBasicAuth("sarah1", "abc123")
				.getForEntity("/cashcards/102", String.class); // kumar2's data
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

}
