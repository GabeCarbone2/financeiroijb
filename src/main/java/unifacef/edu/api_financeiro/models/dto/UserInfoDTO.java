package unifacef.edu.api_financeiro.models.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private UserDTO user;
    private AuthorityDTO authority;
    private LocalDateTime registeredAt;
    private Boolean active;
    private String rg;
    private byte[] profilePic;
    private String name;
    private String lastName;
    private LocalDateTime birthdayDate;
    private String phone1;
    private String phone2;
}
