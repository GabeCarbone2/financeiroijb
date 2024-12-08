package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_origem_movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovementsOrigin {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_origem")
    private Integer id;
    @Column(name = "nm_origem", length = 25)
    private String originName;

    public MovementsOrigin(String originName) {
    }
}
