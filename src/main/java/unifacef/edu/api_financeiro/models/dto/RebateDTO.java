package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RebateDTO extends RebateCreateDTO {
    private Integer id;
    private ExchangeDTO exchange;
    private String description;
    private BigDecimal rebateValue;
}
