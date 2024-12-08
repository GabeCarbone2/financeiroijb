package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.ExchangeCreateDTO;
import unifacef.edu.api_financeiro.models.dto.ExchangeDTO;
import unifacef.edu.api_financeiro.service.ExchangeService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/exchanges")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping
    public ResponseEntity<ExchangeDTO> createExchange(@RequestBody ExchangeCreateDTO exchangeCreateDTO) {
        return new ResponseEntity<>(exchangeService.createExchange(exchangeCreateDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeDTO>> getAllExchanges() {
        return new ResponseEntity<>(exchangeService.getAllExchanges(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExchangeDTO> updateExchange(@RequestBody ExchangeDTO exchangeDTO) {
        return new ResponseEntity<>(exchangeService.updateExchange(exchangeDTO), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExchange(@PathVariable Integer id) {
        exchangeService.deleteExchange(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
