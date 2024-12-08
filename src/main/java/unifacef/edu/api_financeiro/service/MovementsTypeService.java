package unifacef.edu.api_financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.MovementsTypeMapper;
import unifacef.edu.api_financeiro.models.dto.MovementsTypeCreateDTO;
import unifacef.edu.api_financeiro.models.dto.MovementsTypeDTO;
import unifacef.edu.api_financeiro.models.entity.MovementsType;
import unifacef.edu.api_financeiro.repository.DonationRepository;
import unifacef.edu.api_financeiro.repository.MovementsTypeRepository;
import unifacef.edu.api_financeiro.repository.RebateRepository;
import unifacef.edu.api_financeiro.repository.SaleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovementsTypeService {
    @Autowired
    private MovementsTypeRepository movementsTypeRepository;

    public MovementsTypeDTO createMovementsType(MovementsTypeCreateDTO movementsTypeCreateDTO) {
        MovementsType movementsType = MovementsTypeMapper.convertMovementsTypeCreateDTOToEntity(movementsTypeCreateDTO);
        MovementsType savedMovementsType = movementsTypeRepository.save(movementsType);
        return MovementsTypeMapper.convertMovementsTypeEntityToDTO(savedMovementsType);
    }

    public MovementsTypeDTO updateMovementsType(Integer id, MovementsTypeCreateDTO movementsTypeDTO) {
        Optional<MovementsType> existingMovementsType = movementsTypeRepository.findById(id);
        if (!existingMovementsType.isPresent()) {
            return null;
        }

        MovementsType movementsType = existingMovementsType.get();
        MovementsTypeMapper.updateMovementsTypeFromDTO(movementsType, movementsTypeDTO);
        MovementsType updatedMovementsType = movementsTypeRepository.save(movementsType);
        return MovementsTypeMapper.convertMovementsTypeEntityToDTO(updatedMovementsType);
    }


    public List<MovementsTypeDTO> getAllMovementsTypes() {
        return MovementsTypeMapper.convertListOfMovementsTypeToListOfDTOs(movementsTypeRepository.findAll());
    }

    public MovementsTypeDTO getMovementsTypeById(Integer id) {
        MovementsType movementsType = OptionalHelper.getOptionalEntity(movementsTypeRepository.findById(id));
        return MovementsTypeMapper.convertMovementsTypeEntityToDTO(movementsType);
    }

    public void deleteMovementsType(Integer id) {
        MovementsType movementsType = OptionalHelper.getOptionalEntity(movementsTypeRepository.findById(id));
        movementsTypeRepository.delete(movementsType);
    }
}
