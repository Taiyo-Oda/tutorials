/*
 * RESTControllerの作成
 * spring Web コントローラは、HTTP リクエストを処理し、応答するために設計されています。
 */

package example.cashcard;

import java.util.Optional;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

// @RestController : このクラスがRestController型のComponentで、HTTPリクエストを処理できることをSpringに伝える
// @RequestMapping("/cashcards") : @RestControllerに付随するもので、このControllerにアクセスするためにどのアドレスが必要かを示す
@RestController
@RequestMapping("/cashcards")
public class CashCardController {
  private CashCardRepository cashCardRepository;

  public CashCardController(CashCardRepository cashCardRepository) {
    this.cashCardRepository = cashCardRepository;
  }

  /*
   * GETエンドポイント
   * クライアントからのGETリクエストはここで処理されます。
   */
  // @PathVariable
  // 送信するパス変数をコントローラが認識するようにします。
  @GetMapping("/{requestedId}")
  public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
    // Optional.isPreset() : 値(今回であればcachcard)を見つけた場合は、trueなければfalseを返す
    Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
    if (cashCardOptional.isPresent()) {
      return ResponseEntity.ok(cashCardOptional.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /*
   * POSTエンドポイント
   * クライアントからのPOSTリクエストはここで処理されます。
   * POSTするデータはリクエストボディに含まれ、SpringWebはこれをCashCardにでシリアライズしてくれます。
   */
  @PostMapping
  private ResponseEntity<Void> createCashCard(@RequestBody CashCard newCashCardRequest, UriComponentsBuilder ubc) {
    // 新しいCashCardを保存し、データベースから与えられたユニークIDでその保存オブジェクトを返す。
    CashCard savedCashCard = cashCardRepository.save(newCashCardRequest);
    // 呼び出し側が新しく作成された CashCard を GET するために使用する URI です。
    URI locationOfNewCashCard = ubc
        .path("cashcards/{id}")
        .buildAndExpand(savedCashCard.id())
        .toUri();
    return ResponseEntity.created(locationOfNewCashCard).build();
  }

}
