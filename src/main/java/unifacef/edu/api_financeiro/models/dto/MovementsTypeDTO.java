package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementsTypeDTO {
    private Integer id;
    private SaleDTO sale;
    private RebateDTO rebate;
    private DonationDTO donation;
    private String movementTypeName;
}
