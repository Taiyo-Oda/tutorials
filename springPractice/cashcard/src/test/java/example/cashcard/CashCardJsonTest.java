/*
 * テスト駆動開発をspring bootを使用して実行する
 * Jsonフォーマットを使用したシリアライズとデシリアライズのテストです
 */

package example.cashcard;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

// @JsonTest: CashCardJsonTestがJacksonフレームワーク（Springの一部として含まれています）を使用するテストクラスであることを示します。
// これにより、JSONのテストとパースが広範囲にサポートされます。また、JSONオブジェクトをテストするための関連するすべての動作も確立されます。
@JsonTest
public class CashCardJsonTest {

  // Autowiredは、要求された型のオブジェクトを作成するようにSpringに指示するアノテーションです。
  // JacksonTester: Jackson
  // JSONパージング・ライブラリの便利なラッパーです。これは、JSONオブジェクトのシリアライズとデシリアライズを処理します
  private final JacksonTester<CashCard> json;
  private final JacksonTester<CashCard[]> jsonList;

  private CashCard[] cashCards;

  @Autowired
  public CashCardJsonTest(JacksonTester<CashCard> json,
      JacksonTester<CashCard[]> jsonList) {
    this.json = json;
    this.jsonList = jsonList;
  }

  @BeforeEach
  void setUp() {
    cashCards = Arrays.array(
        new CashCard(99L, 123.45),
        new CashCard(100L, 1.00),
        new CashCard(101L, 150.00));
  }

  // 以下はJsonフォーマットを使用したシリアライズとデシリアライズのテストです
  // シリアライゼーションとデシリアライゼーションは、データオブジェクトをポータブルな形式に変換したり、そこから生成したりするために一緒に働きます。
  // データをシリアライズするための最も一般的なデータフォーマットはJSONです。

  // CashCardクラスのシリアライズテスト
  @Test
  public void cashCardSerializationTest() throws IOException {
    CashCard cashCard = cashCards[0];
    assertThat(json.write(cashCard)).isStrictlyEqualToJson("single.json");
    assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
    assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
        .isEqualTo(99);
    assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
    assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
        .isEqualTo(123.45);
  }

  // デシリアライズテスト
  // デシリアライゼーションはシリアライゼーションの逆のプロセスです。ファイルやバイトストリームからアプリケーション用のオブジェクトにデータを変換します。
  // これにより、あるプラットフォームでシリアライズされたオブジェクトを、別のプラットフォームでデシリアライズすることが可能になります。
  // 最初のテストが合格した後、JSONからJavaに変換されるように、データをデシリアライズする2番目のテストです。
  @Test
  public void cashCardDeserializationTest() throws IOException {
    String expected = """
        {
            "id": 99,
            "amount": 123.45
        }
        """;
    assertThat(json.parse(expected))
        .isEqualTo(new CashCard(99L, 123.45));
    assertThat(json.parseObject(expected).id()).isEqualTo(99);
    assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
  }

  @Test
  void cashCardListSerializationTest() throws IOException {
    assertThat(jsonList.write(cashCards)).isStrictlyEqualToJson("list.json");
  }

  @Test
  void cashCardListDeserializationTest() throws IOException {
    String expected = """
        [
            { "id": 99, "amount": 123.45 },
            { "id": 100, "amount": 1.00 },
            { "id": 101, "amount": 150.00 }
        ]
        """;
    assertThat(jsonList.parse(expected)).isEqualTo(cashCards);
  }
}