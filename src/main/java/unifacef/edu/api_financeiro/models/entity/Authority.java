package unifacef.edu.api_financeiro.models.entity;


import jakarta.persistence.*;
import lombok.*;
import unifacef.edu.api_financeiro.models.enums.Role;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "tb_funcao")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Authority {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_funcao")
    private Integer id;
    @Column(name = "nm_funcao", unique = true, length = 60)
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Column(name = "ds_funcao", length = 60)
    @OneToMany(mappedBy = "authority")
    private List<UserInfo> userInfo;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Authority(Role role) {
        this.role = role;
    }
}
