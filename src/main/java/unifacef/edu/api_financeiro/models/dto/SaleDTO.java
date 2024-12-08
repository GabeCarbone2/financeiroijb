package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO extends SaleCreateDTO {
    private Integer id;
    private OutletProductDTO outletProduct;
    private BigDecimal saleValue;
    private String saleDescription;

}
