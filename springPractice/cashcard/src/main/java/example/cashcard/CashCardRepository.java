/*
 * Spring DataとH2でインメモリデータベースでテストデータを管理できるようにします。
 */
package example.cashcard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// CrudRepositoryはSpring Dataが提供するインターフェースである。
// これを拡張すると（あるいはSpring DataのRepositoryの他のサブインターフェース）、Spring BootとSpring Dataが連携して、データベースとのやりとりに必要なCRUDメソッドを自動的に生成してくれる
public interface CashCardRepository extends CrudRepository<CashCard, Long>, PagingAndSortingRepository<CashCard, Long> {

}
