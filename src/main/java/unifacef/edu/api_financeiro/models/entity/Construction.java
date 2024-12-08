package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_obras")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Construction {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_construcao")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Address address;
    @Column(name = "dt_inicio")
    private LocalDateTime startDate;
    @Column(name = "dt_termino")
    private LocalDateTime endDate;
    @Column(name = "situacao_construcao")
    private String constructionStatus;
    @Column(name = "custo_estimado")
    private BigDecimal estimatedCost;
    @Column(name = "custo_total")
    private BigDecimal totalCost;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Construction(Integer id, Address address, LocalDateTime startDate, LocalDateTime endDate, String constructionStatus, BigDecimal estimatedCost, BigDecimal totalCost) {
    }
}
