package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_vendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_prod_outlet")
    private OutletProduct outletProduct;
    @Column(name = "valor_venda")
    private BigDecimal saleValue;
    @Column(name = "ds_venda", length = 100)
    private String saleDescription;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Sale(OutletProduct outletProduct, BigDecimal saleValue, String saleDescription) {
        this.outletProduct = outletProduct;
        this.saleValue = saleValue;
        this.saleDescription = saleDescription;
    }

}