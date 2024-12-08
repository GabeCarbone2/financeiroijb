package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementDTO extends MovementCreateDTO {
    private Integer id;
    private ReceiptDTO receipt;
    private ExpenseDTO expense;
}
