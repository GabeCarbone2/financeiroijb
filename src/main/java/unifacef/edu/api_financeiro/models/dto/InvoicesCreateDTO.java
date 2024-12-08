package unifacef.edu.api_financeiro.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InvoicesCreateDTO {
    private MovementDTO movement;
    @JsonProperty("invoicePhoto")
    private byte[] invoicePhoto;
}
