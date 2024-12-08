package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movement {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_movimentacao")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_receita")
    private Receipt receipt;
    @ManyToOne
    @JoinColumn(name = "id_despesa")
    private Expense expense;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Movement(Receipt receipt, Expense expense) {
    }
}