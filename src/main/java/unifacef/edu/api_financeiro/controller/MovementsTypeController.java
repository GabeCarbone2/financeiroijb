package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.MovementsTypeCreateDTO;
import unifacef.edu.api_financeiro.models.dto.MovementsTypeDTO;
import unifacef.edu.api_financeiro.service.MovementsTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/movements-type")
public class MovementsTypeController {
    @Autowired
    private MovementsTypeService movementsTypeService;

    @PostMapping
    public ResponseEntity<MovementsTypeDTO> createMovementsType(@RequestBody MovementsTypeCreateDTO movementsTypeCreateDTO) {
        return new ResponseEntity<>(movementsTypeService.createMovementsType(movementsTypeCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementsTypeDTO> updateMovementsType(@PathVariable Integer id, @RequestBody MovementsTypeCreateDTO movementsTypeDTO) {
        return new ResponseEntity<>(movementsTypeService.updateMovementsType(id, movementsTypeDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovementsTypeDTO>> getAllMovementsTypes() {
        return new ResponseEntity<>(movementsTypeService.getAllMovementsTypes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementsTypeDTO> getMovementsTypeById(@PathVariable Integer id) {
        return new ResponseEntity<>(movementsTypeService.getMovementsTypeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementsType(@PathVariable Integer id) {
        movementsTypeService.deleteMovementsType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
