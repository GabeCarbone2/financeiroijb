package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "receita")
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_receita")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "id_abatimento")
    private Rebate rebate;
    @Column(name = "dt_recebimento")
    private LocalDateTime receiptDate;
    @Column(name = "dt_vencimento")
    private LocalDateTime expiryDate;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Receipt(Donation donation, Sale sale, Rebate rebate) {
    }
}
