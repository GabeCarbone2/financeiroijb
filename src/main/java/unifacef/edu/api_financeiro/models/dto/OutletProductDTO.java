package unifacef.edu.api_financeiro.models.dto;

import lombok.*;
import unifacef.edu.api_financeiro.models.enums.OutletProductStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutletProductDTO extends OutletProductCreateDTO {
    private Integer id;
    private DonationDTO donation;
    private String outletProductName;
    private String outletProductDescription;
    private OutletProductStatus status;
}
