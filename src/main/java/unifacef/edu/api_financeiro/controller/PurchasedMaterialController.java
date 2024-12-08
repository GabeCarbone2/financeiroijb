package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.PurchasedMaterialCreateDTO;
import unifacef.edu.api_financeiro.models.dto.PurchasedMaterialDTO;
import unifacef.edu.api_financeiro.service.PurchasedMaterialService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/purchased-materials")
public class PurchasedMaterialController {

    @Autowired
    private PurchasedMaterialService purchasedMaterialService;

    @PostMapping
    public ResponseEntity<PurchasedMaterialDTO> createPurchasedMaterial(@RequestBody PurchasedMaterialCreateDTO purchasedMaterialCreateDTO) {
        return new ResponseEntity<>(purchasedMaterialService.createPurchasedMaterial(purchasedMaterialCreateDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PurchasedMaterialDTO>> getAllPurchasedMaterials() {
        return new ResponseEntity<>(purchasedMaterialService.getAllPurchasedMaterials(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PurchasedMaterialDTO>> getAllPurchasedMaterialsByFilter(@RequestParam String name) {
        return new ResponseEntity<>(purchasedMaterialService.getAllPurchasedMaterialsByFilter(name), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PurchasedMaterialDTO> updatePurchasedMaterial(@RequestBody PurchasedMaterialDTO purchasedMaterialDTO) {
        return new ResponseEntity<>(purchasedMaterialService.updatePurchasedMaterial(purchasedMaterialDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchasedMaterial(@PathVariable Integer id) {
        purchasedMaterialService.deletePurchasesMaterial(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
