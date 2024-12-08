package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.ReceiptCreateDTO;
import unifacef.edu.api_financeiro.models.dto.ReceiptDTO;
import unifacef.edu.api_financeiro.service.ReceiptService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<ReceiptDTO> createReceipt(@RequestBody ReceiptCreateDTO receiptDTO) {
        return new ResponseEntity<>(receiptService.createReceipt(receiptDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptDTO> getReceiptById(@PathVariable Integer id) {
        return new ResponseEntity<>(receiptService.getReceiptById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReceiptDTO>> getAllReceipts() {
        return new ResponseEntity<>(receiptService.getAllReceipts(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceiptDTO> updateReceipt(@PathVariable Integer id, @RequestBody ReceiptCreateDTO receiptDTO) {
        return new ResponseEntity<>(receiptService.updateReceipt(id, receiptDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable Integer id) {
        receiptService.deleteReceipt(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}