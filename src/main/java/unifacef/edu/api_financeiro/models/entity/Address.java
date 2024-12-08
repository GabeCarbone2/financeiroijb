package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_enderecos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_endereco")
    private Integer id;
    @Column(name = "cep")
    private String cep;
    @Column(name = "rua")
    private String street;
    @Column(name = "nro_casa")
    private String number;
    @Column(name = "bairro")
    private String neighborhood;
    @Column(name = "complemento")
    private String complement;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Address(Integer id, String cep, String street, String number, String neighborhood, String complement) {
    }
}
