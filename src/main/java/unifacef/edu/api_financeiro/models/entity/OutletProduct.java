package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import unifacef.edu.api_financeiro.models.enums.OutletProductStatus;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_produtos_outlet")
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "statusFilter", condition = "status != INACTIVE")
public class OutletProduct {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_prod_outlet")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "nm_prod_outlet", length = 60)
    private String outletProductName;
    @Column(name = "ds_prod_outlet", length = 100)
    private String outletProductDescription;
    @Column(name = "status", length = 20)
    @Enumerated(EnumType.STRING)
    private OutletProductStatus status;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public OutletProduct(Donation donation, String outletProductName, String outletProductDescription,
                         OutletProductStatus status) {
        this.donation = donation;
        this.outletProductName = outletProductName;
        this.outletProductDescription = outletProductDescription;
        this.status = status;
    }
}
