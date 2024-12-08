package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.service.ExtratoService;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {
    @Autowired
    private ExtratoService extratoService;

    @GetMapping("/{mes}/{ano}")
    public String obterExtrato(
            @RequestParam String clientId,
            @RequestParam int mes,
            @RequestParam int ano,
            @RequestParam int diaInicial,
            @RequestParam int diaFinal,
            @RequestParam boolean agruparCNAB,
            @RequestParam long numeroContaCorrente) {

        return extratoService.getExtrato(clientId, mes, ano, diaInicial, diaFinal, agruparCNAB, numeroContaCorrente);
    }
}
