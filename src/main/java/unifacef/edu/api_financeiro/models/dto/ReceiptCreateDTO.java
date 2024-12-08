package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReceiptCreateDTO {
    private DonationDTO donation;
    private SaleDTO sale;
    private RebateDTO rebate;
    private LocalDateTime receiptDate;
    private LocalDateTime expiryDate;
}
