package unifacef.edu.api_financeiro.models.dto;

import lombok.Data;

@Data
public class PurchasedMaterialCreateDTO {
    private Integer id;
    private String materialName;
    private Integer materialQuantity;
}
