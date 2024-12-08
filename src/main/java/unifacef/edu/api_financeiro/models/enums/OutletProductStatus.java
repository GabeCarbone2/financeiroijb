package unifacef.edu.api_financeiro.models.enums;

import lombok.Getter;

@Getter
public enum OutletProductStatus {
    ACTIVE("ativo"),
    INACTIVE("inativo"),
    SOLD("vendido");

    private final String status;

    OutletProductStatus(String status) {
        this.status = status;
    }
}