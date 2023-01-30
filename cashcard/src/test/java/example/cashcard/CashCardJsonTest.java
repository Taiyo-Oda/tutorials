package example.cashcard;

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
  @Autowired
  private JacksonTester<CashCard> json;

  @Test
  public void cashCardSerializationTest() throws IOException {
    CashCard cashCard = new CashCard(99L, 123.45);
    assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
    assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
    assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
        .isEqualTo(99);
    assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
    assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
        .isEqualTo(123.45);
  }
}