package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstructionDTO {
    private Integer id;
    private AddressDTO addressDTO;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String constructionStatus;
    private BigDecimal estimatedCost;
    private BigDecimal totalCost;

    public ConstructionDTO(Integer id, AddressDTO addressDTO, LocalDateTime startDate, LocalDateTime endDate, String constructionStatus, BigDecimal estimatedCost) {
    }
}
