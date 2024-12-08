package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;

@Data
public class MovementsTypeCreateDTO {
    private SaleDTO sale;
    private RebateDTO rebate;
    private DonationDTO donation;
    private String movementTypeName;
}
