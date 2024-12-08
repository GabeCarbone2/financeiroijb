package unifacef.edu.api_financeiro.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoicesDTO {
    private Integer id;
    private MovementDTO movement;
    @JsonProperty("invoicePhoto")
    private byte[] invoicePhoto;
}
