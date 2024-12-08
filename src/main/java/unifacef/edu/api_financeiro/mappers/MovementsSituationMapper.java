package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.MovementsSituationDTO;
import unifacef.edu.api_financeiro.models.entity.MovementsSituation;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovementsSituationMapper {

    public static MovementsSituation convertMovementsSituationDTOToEntity(MovementsSituationDTO movementsSituationDTO) {
        MovementsSituation entity = new MovementsSituation();
        entity.setId(movementsSituationDTO.getId());
        entity.setSituationName(movementsSituationDTO.getSituationName());
        return entity;
    }

    public static MovementsSituationDTO convertMovementsSituationEntityToDTO(MovementsSituation movementsSituation) {
        MovementsSituationDTO dto = new MovementsSituationDTO();
        dto.setId(movementsSituation.getId());
        dto.setSituationName(movementsSituation.getSituationName());
        return dto;
    }

    public static List<MovementsSituationDTO> convertListOfMovementsSituationToListOfDTOs(List<MovementsSituation> movementsSituations) {
        List<MovementsSituationDTO> movementsSituationDTOS = new ArrayList<>();
        for (MovementsSituation movementsSituation : movementsSituations) {
            movementsSituationDTOS.add(convertMovementsSituationEntityToDTO(movementsSituation));
        }
        return movementsSituationDTOS;
    }

    public static void updateMovementsSituationFromDTO(MovementsSituation movementsSituation, MovementsSituationDTO movementsSituationDTO) {
        movementsSituation.setSituationName(movementsSituation.getSituationName());
    }
}
