package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDTO extends ExchangeCreateDTO {
    private Integer id;
    private OutletProductDTO outletProduct;
    private String exchangesDescription;
}
