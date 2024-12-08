package unifacef.edu.api_financeiro.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

    @Data
    @Entity
    @Table(name = "tb_abatimentos")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class Rebate {
        @Id
        @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
        @Column(name = "id_abatimento")
        private Integer id;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_troca")
        private Exchange exchange;
        @Column(name = "ds_abatimento", length = 100)
        private String description;
        @Column(name = "valor_abatimento")
        private BigDecimal rebateValue;

        public Rebate(Exchange exchange, String description, BigDecimal rebateValue) {
            this.exchange = exchange;
            this.description = description;
            this.rebateValue = rebateValue;
        }
    }
