package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Table(name = "tb_notas_fiscais")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_nota_fiscal")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_movimentacao")
    private Movement movement;
    @Column(name = "foto_nota_fiscal")
    private byte[] invoicePhoto;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Invoice(Movement movement, byte[] invoicePhoto) {
    }
}
