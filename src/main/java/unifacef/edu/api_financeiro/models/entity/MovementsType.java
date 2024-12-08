package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_tipos_movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovementsType {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_movimentacao")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venda")
    private Sale sale;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_abatimento")
    private Rebate rebate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "nm_tipo_movimentacao", length = 25)
    private String movementTypeName;

    public MovementsType(Sale sale, Rebate rebate, Donation donation, String movementTypeName) {
    }
}
