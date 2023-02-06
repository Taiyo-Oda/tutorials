package example.cashcard;

import org.springframework.data.annotation.Id;

// @id : CashCardRepositoryの@Idとしてidを設定します。
public record CashCard(@Id Long id, Double amount, String owner) {
}