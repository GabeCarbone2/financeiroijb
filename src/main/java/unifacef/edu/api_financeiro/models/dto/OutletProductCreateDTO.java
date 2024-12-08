package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;
import unifacef.edu.api_financeiro.models.enums.OutletProductStatus;

@Data
public class OutletProductCreateDTO {
    private DonationDTO donation;
    private String outletProductName;
    private String outletProductDescription;
    private OutletProductStatus status;
}

