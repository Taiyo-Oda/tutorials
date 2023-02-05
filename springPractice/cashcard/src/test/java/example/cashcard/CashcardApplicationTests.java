/*
 * REST APIに対してリクエストを行うことを想定したテストクラスです。
 * 
 * データストア（ここではインメモリ）に対して、HTTPリクエストを行います。
 */

package example.cashcard;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.net.URI;

// assertjはアサーション（検証用）ライブラリです
import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
// これにより、Spring Bootアプリケーションが起動され、テストがそれに対してリクエストを実行できるようになります。
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
	void shouldReturnACashCardWhenDataIsSaved() {
		// urlとレスポンスを指定してGETリクエスト
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		// レスポンスを、多くのヘルパーメソッドを持つ JSON 対応のオブジェクトに変換する
		DocumentContext documentContext = JsonPath.parse(response.getBody());
		Number id = documentContext.read("$.id");
		assertThat(id).isEqualTo(99);
		Double amount = documentContext.read("$.amount");
		assertThat(amount).isEqualTo(123.45);
	}

	/*
	 * GETリクエストテスト用クラス
	 * GETエンドポイントを作成しurlに指定したIDでGETリクエストのテストを実施します。
	 * このテストでは、インメモリに未設定のIDを指定するため、responseでNOT_FOUNDが帰ってくることが期待されます。
	 */
	@Test
	void shouldNotReturnACashCardWithAnUnknownId() {
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();
	}

	/*
	 * POSTリクエストテスト用クラス
	 */
	@Test
	void shouldCreateANewCashCard() {
		// id の指定は、既存のリソースに対してアップデートを実行する際にサポートされる
		// CashCard newCashCard = new CashCard(44L, 250.00);
		CashCard newCashCard = new CashCard(null, 250.00);
		// POSTで新しいリソースが作成された場合、statusとして201 (Created)が返ってくることを期待する
		ResponseEntity<Void> createResponse = restTemplate.postForEntity("/cashcards", newCashCard, Void.class);
		assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		// 作成されたリソースの識別子を含むレスポンスヘッダを取得
		URI locationOfNewCashCard = createResponse.getHeaders().getLocation();
		ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewCashCard, String.class);
		assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		// レスポンスボディをJSON対応のオブジェクトに変換して取得する
		DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
		Number id = documentContext.read("$.id");
		Double amount = documentContext.read("$.amount");
		assertThat(id).isNotNull();
		assertThat(amount).isEqualTo(250.00);
	}

}
