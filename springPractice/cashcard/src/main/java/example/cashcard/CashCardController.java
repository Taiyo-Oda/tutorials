/*
 * RESTControllerの作成
 * pring Web コントローラは、HTTP リクエストを処理し、応答するために設計されています。
 */

package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController : このクラスがRestController型のComponentで、HTTPリクエストを処理できることをSpringに伝える
// @RequestMapping("/cashcards") : @RestControllerに付随するもので、このControllerにアクセスするためにどのアドレスが必要かを示す
@RestController
@RequestMapping("/cashcards")
public class CashCardController {

  // @GetMapping :
  // メソッドをハンドラメソッドとしてマークします。cashcards/{requestedID}にマッチするGETリクエストは、このメソッドによって処理されます。
  @GetMapping("/{requestedId}")
  public ResponseEntity<CashCard> findById() {
    CashCard cashCard = new CashCard(99L, 123.45);
    return ResponseEntity.ok(cashCard);
  }

}
