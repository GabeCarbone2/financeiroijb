package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_despesa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_despesa")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_material_comprado")
    private PurchasedMaterial purchasedMaterial;
    @ManyToOne
    @JoinColumn(name = "id_obra")
    private Construction construction;
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


    public Expense(PurchasedMaterial purchasedMaterial, Construction construction, LocalDateTime receiptDate, LocalDateTime expiryDate) {
    }
}

