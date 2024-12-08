package unifacef.edu.api_financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.api_financeiro.models.entity.Donation;
import unifacef.edu.api_financeiro.service.DonationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Integer id) {
        Optional<Donation> donation = donationService.findById(id);
        return donation.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.save(donation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donation> updateDonation(@PathVariable Integer id, @RequestBody Donation donationDetails) {
        Optional<Donation> donation = donationService.findById(id);
        if (donation.isPresent()) {
            Donation updatedDonation = donation.get();
            updatedDonation.setDonationType(donationDetails.getDonationType());
            return ResponseEntity.ok(donationService.save(updatedDonation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable Integer id) {
        if (donationService.findById(id).isPresent()) {
            donationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}