/*
 * APIのGETエンドポイントを作成する
 * Spring Bootを使用してテスト駆動開発でGETエンドポイントを作成します
 * エンドポイント：ここではAPIにアクセスするためのURIのことを言う
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

import static org.assertj.core.api.Assertions.assertThat;

// これにより、Spring Bootアプリケーションが起動され、テストがそれに対してリクエストを実行できるようになります。
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardApplicationTests {

	// 自動化されたTestRestTemplate restTemplateです。
	// テストヘルパーを注入して、ローカルで動作しているアプリケーションにHTTPリクエストを行えるようにするようSpringに依頼しました。
	// AutowiredはSpringの依存性注入の一形態ですが、テストでのみ使用するのがベストであることに注意してください。
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnACashCardWhenDataIsSaved() {
		// restTemplateはresponseと名付けたResponseEntityを返します。
		// これも有用なSpringオブジェクトで、リクエストで何が起こったかについての貴重な情報を提供します。
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);

		// HTTPレスポンスステータスコードも含めて、レスポンスの多くの側面を調べることができます。
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		// レスポンスを、多くのヘルパーメソッドを持つ JSON 対応のオブジェクトに変換する
		DocumentContext documentContext = JsonPath.parse(response.getBody());
		Number id = documentContext.read("$.id");
		assertThat(id).isEqualTo(99);

		Double amount = documentContext.read("$.amount");
		assertThat(amount).isEqualTo(123.45);
	}

}
