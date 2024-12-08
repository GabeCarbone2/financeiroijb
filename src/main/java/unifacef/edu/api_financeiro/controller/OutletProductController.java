package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.OutletProductCreateDTO;
import unifacef.edu.api_financeiro.models.dto.OutletProductDTO;
import unifacef.edu.api_financeiro.service.OutletProductService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/outlet-products")
public class OutletProductController {
    @Autowired
    private OutletProductService outletProductService;

    @PostMapping
    public ResponseEntity<OutletProductDTO> createOutletProduct(@RequestBody OutletProductCreateDTO outletProductCreateDTO) {
        return new ResponseEntity<>(outletProductService.createOutletProduct(outletProductCreateDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OutletProductDTO>> getAllOutletProducts() {
        return new ResponseEntity<>(outletProductService.getAllOutletProducts(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<OutletProductDTO>> getAllOutletProductsByFilter(@RequestParam String nameOrDescription) {
        return new ResponseEntity<>(outletProductService.getAllOutletProductsByFilter(nameOrDescription), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutletProductDTO> updateOutletProduct(@PathVariable Integer id, @RequestBody OutletProductDTO outletProductDTO) {
        outletProductDTO.setId(id);
        return new ResponseEntity<>(outletProductService.updateOutletProduct(outletProductDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOutletProduct(@PathVariable Integer id) {
        outletProductService.deleteOutletProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
