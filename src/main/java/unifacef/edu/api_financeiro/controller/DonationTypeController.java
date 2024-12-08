package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.entity.DonationType;
import unifacef.edu.api_financeiro.service.DonationTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donation-types")
public class DonationTypeController {

    @Autowired
    private DonationTypeService donationTypeService;

    @GetMapping
    public List<DonationType> getAllDonationTypes() {
        return donationTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationType> getDonationTypeById(@PathVariable Integer id) {
        Optional<DonationType> donationType = donationTypeService.findById(id);
        return donationType.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DonationType createDonationType(@RequestBody DonationType donationType) {
        return donationTypeService.save(donationType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonationType> updateDonationType(@PathVariable Integer id, @RequestBody DonationType donationTypeDetails) {
        Optional<DonationType> donationType = donationTypeService.findById(id);
        if (donationType.isPresent()) {
            DonationType updatedDonationType = donationType.get();
            updatedDonationType.setTypeDonationName(donationTypeDetails.getTypeDonationName());
            return ResponseEntity.ok(donationTypeService.save(updatedDonationType));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonationType(@PathVariable Integer id) {
        if (donationTypeService.findById(id).isPresent()) {
            donationTypeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}