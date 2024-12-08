package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.MovementCreateDTO;
import unifacef.edu.api_financeiro.models.dto.MovementDTO;
import unifacef.edu.api_financeiro.service.MovementService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/movements")
public class MovementController {
    @Autowired
    private MovementService movementService;

    @PostMapping
    public ResponseEntity<MovementDTO> createMovement(@RequestBody MovementCreateDTO movementDTO) {
        return new ResponseEntity<>(movementService.createMovement(movementDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementDTO> getMovementById(@PathVariable Integer id) {
        return new ResponseEntity<>(movementService.getMovementById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovementDTO>> getAllMovements() {
        return new ResponseEntity<>(movementService.getAllMovements(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementDTO> updateMovement(@PathVariable Integer id, @RequestBody MovementCreateDTO movementDTO) {
        return new ResponseEntity<>(movementService.updateMovement(id, movementDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Integer id) {
        movementService.deleteMovement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}