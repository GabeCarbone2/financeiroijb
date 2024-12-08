package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
    @Entity
    @Table(name = "tb_tipos_doacoes")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class DonationType {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_doacao")
    private Integer id;
    @Column(name = "nm_tipo_doacao", length = 30)
    private String typeDonationName;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public DonationType(String typeDonationName) {
        this.typeDonationName = typeDonationName;
    }
}

