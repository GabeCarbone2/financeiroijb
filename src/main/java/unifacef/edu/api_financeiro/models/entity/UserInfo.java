package unifacef.edu.api_financeiro.models.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import unifacef.edu.api_financeiro.models.idClasses.UserInfoId;

@Data
@Entity
@Table(name = "tb_infos_usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @EmbeddedId
    private UserInfoId id;

    @MapsId("user")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_funcao")
    private Authority authority;
    @Column(name = "dt_registro")
    private LocalDateTime registeredAt;
    @Column(name = "ativo")
    private Boolean active;
    @Column(name = "rg", length = 9)
    private String rg;
    @Column(name = "foto_perfil")
    @Lob
    private byte[] profilePic;
    @Column(name = "nome", length = 20)
    private String name;
    @Column(name = "sobrenome", length = 40)
    private String lastName;
    @Column(name = "dt_nascimento")
    private LocalDateTime birthdayDate;
    @Column(name = "celular1", length = 11)
    private String phone1;
    @Column(name = "celular2", length = 11)
    private String phone2;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}