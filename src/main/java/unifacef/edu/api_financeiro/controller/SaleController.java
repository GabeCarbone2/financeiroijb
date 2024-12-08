package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.SaleCreateDTO;
import unifacef.edu.api_financeiro.models.dto.SaleDTO;
import unifacef.edu.api_financeiro.service.SaleService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleCreateDTO saleCreateDTO) {
        return new ResponseEntity<>(saleService.createSale(saleCreateDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        return new ResponseEntity<>(saleService.getAllSales(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Integer id, @RequestBody SaleDTO saleDTO) {
        saleDTO.setId(id);
        return new ResponseEntity<>(saleService.updateOutletProduct(saleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
        saleService.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
