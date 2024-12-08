package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private Integer id;
    private PurchasedMaterialDTO purchasedMaterialDTO;
    private ConstructionDTO constructionDTO;
    private LocalDateTime receiptDate;
    private LocalDateTime expiryDate;
}
