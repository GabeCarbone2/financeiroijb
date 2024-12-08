package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;

@Data
public class ExchangeCreateDTO {
    private OutletProductDTO outletProduct;
    private String exchangesDescription;
}
