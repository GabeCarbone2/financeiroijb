package unifacef.edu.api_financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.MovementMapper;
import unifacef.edu.api_financeiro.models.dto.MovementCreateDTO;
import unifacef.edu.api_financeiro.models.dto.MovementDTO;
import unifacef.edu.api_financeiro.models.entity.Movement;
import unifacef.edu.api_financeiro.repository.MovementRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovementService {
    @Autowired
    private MovementRepository movementRepository;

    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

    @Transactional
    public MovementDTO createMovement(MovementCreateDTO movementDTO) {
        Movement movement = MovementMapper.convertMovementDTOIntoMovement(movementDTO);
        movement = save(movement);
        return MovementMapper.convertMovementIntoMovementDTO(movement);
    }

    public List<MovementDTO> getAllMovements() {
        return MovementMapper.convertListOfMovementIntoListOfMovementDTO(movementRepository.findAll());
    }

    public MovementDTO getMovementById(Integer id) {
        Movement movement = OptionalHelper.getOptionalEntity(movementRepository.findById(id));
        return MovementMapper.convertMovementIntoMovementDTO(movement);
    }

    @Transactional
    public MovementDTO updateMovement(Integer id, MovementCreateDTO movementDTO) {
        Movement existingMovement = OptionalHelper.getOptionalEntity(movementRepository.findById(id));
        MovementMapper.updateMovement(movementDTO, existingMovement);
        Movement updatedMovement = movementRepository.save(existingMovement);

        return MovementMapper.convertMovementIntoMovementDTO(updatedMovement);
    }

    @Transactional
    public void deleteMovement(Integer id) {
        Movement movement = OptionalHelper.getOptionalEntity(movementRepository.findById(id));
        movementRepository.delete(movement);
    }
}
