/*
 * RESTControllerの作成
 * spring Web コントローラは、HTTP リクエストを処理し、応答するために設計されています。
 */

package example.cashcard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

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
   * GETエンドポイント(リスト取得用)
   * リソースのリストを取得する
   */
  // @GetMapping()
  // public ResponseEntity<Iterable<CashCard>> findAll() {
  // // findAll()が実行されると自動的にデータベースからすべてのCashCardレコードを返します。
  // return ResponseEntity.ok(cashCardRepository.findAll());
  // }

  /*
   * GETエンドポイント(リスト取得用)
   * リソースのリストを措定した内容でソートして取得する
   */
  @GetMapping
  public ResponseEntity<Collection<CashCard>> findAll(Pageable pageable) {
    // URIパラメータにpage=0&size=1を指定したので、pageableには必要な値が格納されます。
    Page<CashCard> page = cashCardRepository.findAll(
        // リクエストクエリパラメータからそれぞれ該当する値を取得します
        // 3つの必須パラメータのいずれかがアプリケーションに渡されない場合、getSortOr()
        // メソッドが、ページ、サイズ、ソートの各パラメータにデフォルト値を指定する
        PageRequest.of(
            pageable.getPageNumber(),
            pageable.getPageSize(),
            pageable.getSortOr(Sort.by(Sort.Direction.ASC, "amount"))));
    return ResponseEntity.ok(page.toList());
  }

  /*
   * POSTエンドポイント
   * クライアントからのPOSTリクエストはここで処理されます。
   * POSTす るデータはリクエストボディに含まれ、SpringWebはこれをCashCardにでシリアライズしてくれます。
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
