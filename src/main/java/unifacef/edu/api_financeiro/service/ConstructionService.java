package unifacef.edu.api_financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.mappers.AddressMapper;
import unifacef.edu.api_financeiro.mappers.ConstructionMapper;
import unifacef.edu.api_financeiro.models.dto.ConstructionDTO;
import unifacef.edu.api_financeiro.models.entity.Construction;
import unifacef.edu.api_financeiro.models.entity.Address;
import unifacef.edu.api_financeiro.repository.ConstructionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructionService {

    @Autowired
    private ConstructionRepository constructionRepository;

    public List<Construction> getAllConstructions() {
        return constructionRepository.findAll();
    }

    public Optional<Construction> getConstructionById(Integer id) {
        return constructionRepository.findById(id);
    }

    public Construction createConstruction(ConstructionDTO constructionDTO) {
        Construction construction = ConstructionMapper.convertConstructionDTOToEntity(constructionDTO);

        if (constructionDTO.getAddressDTO() != null) {
            Address address = AddressMapper.convertAddressDTOToEntity(constructionDTO.getAddressDTO());
            construction.setAddress(address);
        }

        return constructionRepository.save(construction);
    }

    public Construction updateConstruction(Integer id, ConstructionDTO constructionDTO) {
        Optional<Construction> existingConstruction = constructionRepository.findById(id);
        if (existingConstruction.isPresent()) {
            Construction construction = ConstructionMapper.convertConstructionDTOToEntity(constructionDTO);

            if (constructionDTO.getAddressDTO() != null) {
                Address address = AddressMapper.convertAddressDTOToEntity(constructionDTO.getAddressDTO());
                construction.setAddress(address);
            }

            construction.setId(id);
            return constructionRepository.save(construction);
        }
        return null;
    }

    public void deleteConstruction(Integer id) {
        constructionRepository.deleteById(id);
    }
}
