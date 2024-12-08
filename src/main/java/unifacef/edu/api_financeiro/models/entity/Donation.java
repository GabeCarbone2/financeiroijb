package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
    @Entity
    @Table(name = "tb_doacoes")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class Donation {
        @Id
        @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
        @Column(name = "id_doacao")
        private Integer Id;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_tipo_doacao")
        private DonationType donationType;
        @Column(name = "dt_criacao")
        private LocalDateTime createdAt;
        @Column(name = "dt_alteracao")
        private LocalDateTime updatedAt;
        @Column(name = "dt_exclusao")
        private LocalDateTime deletedAt;

    public Donation(DonationType donationType) {
        this.donationType = donationType;
    }

    }
