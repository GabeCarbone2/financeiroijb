package unifacef.edu.api_financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.models.entity.DonationType;
import unifacef.edu.api_financeiro.repository.DonationTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonationTypeService {
    @Autowired
    private DonationTypeRepository donationTypeRepository;

    public List<DonationType> findAll() {
        return donationTypeRepository.findAll();
    }

    public Optional<DonationType> findById(Integer id) {
        return donationTypeRepository.findById(id);
    }

    public DonationType save(DonationType donationType) {
        return donationTypeRepository.save(donationType);
    }

    public void deleteById(Integer id) {
        donationTypeRepository.deleteById(id);
    }
}
