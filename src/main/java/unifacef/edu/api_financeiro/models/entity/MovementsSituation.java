package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_situacoes_movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovementsSituation {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_situacao")
    private Integer id;
    @Column(name = "nm_situacao")
    private String situationName;

}