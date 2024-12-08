package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RebateCreateDTO {
    private ExchangeDTO exchange;
    private String description;
    private BigDecimal rebateValue;
}
