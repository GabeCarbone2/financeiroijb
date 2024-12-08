package unifacef.edu.api_financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.models.entity.Donation;
import unifacef.edu.api_financeiro.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public Optional<Donation> findById(Integer id) {
        return donationRepository.findById(id);
    }

    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }

    public void deleteById(Integer id) {
        donationRepository.deleteById(id);
    }
}