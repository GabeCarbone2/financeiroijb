package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {
    private Integer id;
    private String cep;
    private String street;
    private String number;
    private String neighborhood;
    private String complement;
}