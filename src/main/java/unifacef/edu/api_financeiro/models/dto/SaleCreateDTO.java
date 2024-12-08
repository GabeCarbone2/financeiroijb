package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleCreateDTO {
    private OutletProductDTO outletProduct;
    private BigDecimal saleValue;
    private String saleDescription;
}
