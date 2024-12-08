package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.MovementCreateDTO;
import unifacef.edu.api_financeiro.models.dto.MovementDTO;
import unifacef.edu.api_financeiro.models.entity.Movement;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovementMapper {
    public static Movement convertMovementDTOIntoMovement(MovementCreateDTO movementDTO) {
        return new Movement(
                ReceiptMapper.convertReceiptDTOIntoReceipt(movementDTO.getReceipt()),
                ExpenseMapper.convertExpenseDTOIntoExpense(movementDTO.getExpense())
        );
    }

    public static MovementDTO convertMovementIntoMovementDTO(Movement movement) {
        return new MovementDTO(
                movement.getId(),
                ReceiptMapper.convertReceiptIntoReceiptDTO(movement.getReceipt()),
                ExpenseMapper.convertExpenseIntoExpenseDTO(movement.getExpense())
        );
    }

    public static List<MovementDTO> convertListOfMovementIntoListOfMovementDTO(List<Movement> movements) {
        List<MovementDTO> movementDTOs = new ArrayList<>();
        for (Movement movement : movements) {
            movementDTOs.add(convertMovementIntoMovementDTO(movement));
        }
        return movementDTOs;
    }

    public static void updateMovement(MovementCreateDTO movementUpdate, Movement movement) {
        movement.setReceipt(ReceiptMapper.convertReceiptDTOIntoReceipt(movementUpdate.getReceipt()));
        movement.setExpense(ExpenseMapper.convertExpenseDTOIntoExpense(movementUpdate.getExpense()));
    }

}
