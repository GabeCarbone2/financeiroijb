package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDTO {
    private Integer id;
    private DonationTypeDTO donationType;
}
