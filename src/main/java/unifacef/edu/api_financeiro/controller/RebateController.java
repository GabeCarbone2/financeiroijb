package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.RebateCreateDTO;
import unifacef.edu.api_financeiro.models.dto.RebateDTO;
import unifacef.edu.api_financeiro.service.RebateService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/rebates")
public class RebateController {
    @Autowired
    private RebateService rebateService;

    @PostMapping
    public ResponseEntity<RebateDTO> createRebate(@RequestBody RebateCreateDTO rebateCreateDTO) {
        return new ResponseEntity<>(rebateService.createRebate(rebateCreateDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RebateDTO>> getAllRebates() {
        return new ResponseEntity<>(rebateService.getAllRebates(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RebateDTO> updateRebate(@PathVariable Integer id, @RequestBody RebateDTO rebateDTO) {
        rebateDTO.setId(id);
        return new ResponseEntity<>(rebateService.updateRebate(rebateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRebate(@PathVariable Integer id) {
        rebateService.deleteRebate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
