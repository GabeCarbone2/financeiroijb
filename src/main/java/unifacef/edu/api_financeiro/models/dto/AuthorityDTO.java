package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;
import unifacef.edu.api_financeiro.models.enums.Role;

@Data
public class AuthorityDTO {
    private Integer id;
    private Role role;
}
