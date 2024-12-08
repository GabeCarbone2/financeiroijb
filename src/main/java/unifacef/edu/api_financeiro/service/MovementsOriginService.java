package unifacef.edu.api_financeiro.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.MovementsOriginMapper;
import unifacef.edu.api_financeiro.models.dto.MovementsOriginDTO;
import unifacef.edu.api_financeiro.models.entity.MovementsOrigin;
import unifacef.edu.api_financeiro.repository.MovementsOriginRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovementsOriginService {

    @Autowired
    private MovementsOriginRepository movementsOriginRepository;

    public MovementsOrigin save(MovementsOrigin movementsOrigin) {
        return movementsOriginRepository.save(movementsOrigin);
    }

    @Transactional
    public MovementsOriginDTO createMovementsOrigin(MovementsOriginDTO movementsOriginDTO) {
        MovementsOrigin movementsOrigin = MovementsOriginMapper.convertMovementsOriginDTOIntoMovement(movementsOriginDTO);
        movementsOrigin = save(movementsOrigin);
        return MovementsOriginMapper.convertMovementsOriginEntityIntoMovementDTO(movementsOrigin);
    }

    public List<MovementsOriginDTO> getAllMovementsOrigins() {
        return MovementsOriginMapper.convertListOfMovementsOriginIntoListOfMovementsOriginDTO(movementsOriginRepository.findAll());
    }

    public MovementsOriginDTO getMovementsOriginById(Integer id) {
        MovementsOrigin movementsOrigin = OptionalHelper.getOptionalEntity(movementsOriginRepository.findById(id));
        return MovementsOriginMapper.convertMovementsOriginEntityIntoMovementDTO(movementsOrigin);
    }

    public MovementsOriginDTO updateMovementsOrigin(Integer id, MovementsOriginDTO movementsOriginDTO) {
        Optional<MovementsOrigin> existingMovementsOrigin = movementsOriginRepository.findById(id);
        if (!existingMovementsOrigin.isPresent()) {
            return null;
        }

        MovementsOrigin movementsOriginToUpdate = existingMovementsOrigin.get();
        MovementsOriginMapper.updateMovementsOrigin(movementsOriginToUpdate, movementsOriginDTO);
        MovementsOrigin updatedMovementsOrigin = movementsOriginRepository.save(movementsOriginToUpdate);
        return MovementsOriginMapper.convertMovementsOriginEntityIntoMovementDTO(updatedMovementsOrigin);
    }

    public void deleteMovementsOrigin(Integer id) {
        MovementsOrigin movementsOrigin = OptionalHelper.getOptionalEntity(movementsOriginRepository.findById(id));
        movementsOriginRepository.delete(movementsOrigin);
    }
}
