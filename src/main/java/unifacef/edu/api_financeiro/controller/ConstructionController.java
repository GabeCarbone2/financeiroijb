package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.dto.ConstructionDTO;
import unifacef.edu.api_financeiro.models.entity.Construction;
import unifacef.edu.api_financeiro.service.ConstructionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/constructions")
public class ConstructionController {

    @Autowired
    private ConstructionService constructionService;

    @GetMapping
    public ResponseEntity<List<Construction>> getAllConstructions() {
        List<Construction> constructions = constructionService.getAllConstructions();
        if (constructions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(constructions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Construction> getConstructionById(@PathVariable Integer id) {
        Optional<Construction> construction = constructionService.getConstructionById(id);
        if (construction.isPresent()) {
            return new ResponseEntity<>(construction.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Construction> createConstruction(@RequestBody ConstructionDTO constructionDTO) {
        Construction createdConstruction = constructionService.createConstruction(constructionDTO);
        return new ResponseEntity<>(createdConstruction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Construction> updateConstruction(@PathVariable Integer id, @RequestBody ConstructionDTO constructionDTO) {
        Construction updatedConstruction = constructionService.updateConstruction(id, constructionDTO);
        if (updatedConstruction != null) {
            return new ResponseEntity<>(updatedConstruction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConstruction(@PathVariable Integer id) {
        constructionService.deleteConstruction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
