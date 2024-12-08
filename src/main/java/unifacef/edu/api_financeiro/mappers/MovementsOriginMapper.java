package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.MovementsOriginDTO;
import unifacef.edu.api_financeiro.models.entity.MovementsOrigin;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovementsOriginMapper {

    public static MovementsOrigin convertMovementsOriginDTOIntoMovement(MovementsOriginDTO dto) {
        return new MovementsOrigin(
                dto.getOriginName()
        );
    }

    public static MovementsOriginDTO convertMovementsOriginEntityIntoMovementDTO(MovementsOrigin entity) {
        return new MovementsOriginDTO(
                entity.getId(),
                entity.getOriginName()
        );
    }

    public static List<MovementsOriginDTO> convertListOfMovementsOriginIntoListOfMovementsOriginDTO(List<MovementsOrigin> movements) {
        List<MovementsOriginDTO> movementsOriginDTOS = new ArrayList<>();
        for (MovementsOrigin movementsOrigin : movements) {
            movementsOriginDTOS.add(convertMovementsOriginEntityIntoMovementDTO(movementsOrigin));
        }
        return movementsOriginDTOS;
    }

    public static void updateMovementsOrigin(MovementsOrigin movementsOrigin, MovementsOriginDTO movementsOriginDTO) {
        movementsOrigin.setOriginName(movementsOriginDTO.getOriginName());
    }
}
