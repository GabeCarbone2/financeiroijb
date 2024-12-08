package unifacef.edu.api_financeiro.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExtratoService {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "https://api.sicoob.com.br/conta-corrente/v4";


    public ExtratoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getExtrato(String clientId, int mes, int ano, int diaInicial, int diaFinal, boolean agruparCNAB, long numeroContaCorrente) {
        String url = BASE_URL + "/extrato/" + mes + "/" + ano +
                "?dialInicial=" + diaInicial +
                "&diaFinal=" + diaFinal +
                "&agruparCNAB=" + agruparCNAB +
                "&numeroContaCorrente=" + numeroContaCorrente;

        HttpHeaders headers = new HttpHeaders();
        headers.set("client_id", clientId);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
