package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;

@Data
public class MovementCreateDTO {
    private ReceiptDTO receipt;
    private ExpenseDTO expense;
}
