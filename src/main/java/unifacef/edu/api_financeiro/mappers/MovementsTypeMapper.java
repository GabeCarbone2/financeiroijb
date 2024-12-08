package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.MovementsTypeCreateDTO;
import unifacef.edu.api_financeiro.models.dto.MovementsTypeDTO;
import unifacef.edu.api_financeiro.models.entity.MovementsType;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovementsTypeMapper {
    public static MovementsType convertMovementsTypeCreateDTOToEntity(MovementsTypeCreateDTO movementsTypeCreateDTO) {
        return new MovementsType(
                SaleMapper.convertSaleCreateDTOIntoSale(movementsTypeCreateDTO.getSale()),
                RebateMapper.convertRebateCreateDTOIntoRebate(movementsTypeCreateDTO.getRebate()),
                DonationMapper.convertDonationCreateDTOIntoDonation(movementsTypeCreateDTO.getDonation()),
                movementsTypeCreateDTO.getMovementTypeName()
        );
    }

    public static MovementsTypeDTO convertMovementsTypeEntityToDTO(MovementsType movementsType) {
        return new MovementsTypeDTO(
                movementsType.getId(),
                SaleMapper.convertSaleIntoSaleDTO(movementsType.getSale()),
                RebateMapper.convertRebateIntoRebateDTO(movementsType.getRebate()),
                DonationMapper.convertDonationIntoDonationDTO(movementsType.getDonation()),
                movementsType.getMovementTypeName()
        );
    }

    public static List<MovementsTypeDTO> convertListOfMovementsTypeToListOfDTOs(List<MovementsType> movementsTypes) {
        List<MovementsTypeDTO> movementsTypeDTOs = new ArrayList<>();
        for (MovementsType movementsType : movementsTypes) {
            movementsTypeDTOs.add(convertMovementsTypeEntityToDTO(movementsType));
        }
        return movementsTypeDTOs;
    }

    public static void updateMovementsTypeFromDTO(MovementsType movementsType, MovementsTypeCreateDTO movementsTypeDTO) {
        movementsType.setSale(SaleMapper.convertSaleCreateDTOIntoSale(movementsTypeDTO.getSale()));
        movementsType.setRebate(RebateMapper.convertRebateCreateDTOIntoRebate(movementsTypeDTO.getRebate()));
        movementsType.setDonation(DonationMapper.convertDonationCreateDTOIntoDonation(movementsTypeDTO.getDonation()));
        movementsType.setMovementTypeName(movementsTypeDTO.getMovementTypeName());
    }
}