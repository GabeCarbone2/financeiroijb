package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String email;
    private String cpf;
    private String password;
}
