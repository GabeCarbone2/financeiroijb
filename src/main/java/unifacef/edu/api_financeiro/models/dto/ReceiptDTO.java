package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO extends ReceiptCreateDTO {
    private Integer id;
    private DonationDTO donation;
    private SaleDTO sale;
    private RebateDTO rebate;
    private LocalDateTime receiptDate;
    private LocalDateTime expiryDate;

}
