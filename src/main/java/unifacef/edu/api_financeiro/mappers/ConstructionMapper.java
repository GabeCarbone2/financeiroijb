package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.AddressDTO;
import unifacef.edu.api_financeiro.models.dto.ConstructionDTO;
import unifacef.edu.api_financeiro.models.entity.Address;
import unifacef.edu.api_financeiro.models.entity.Construction;

@Component
public class ConstructionMapper {

    public static Construction convertConstructionDTOToEntity(ConstructionDTO dto) {
        Address address = null;
        if (dto.getAddressDTO() != null) {
            address = AddressMapper.convertAddressDTOToEntity(dto.getAddressDTO());
        }

        return new Construction(
                dto.getId(),
                address,
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getConstructionStatus(),
                dto.getEstimatedCost(),
                dto.getTotalCost()
        );
    }

    public static ConstructionDTO convertConstructionEntityToDTO(Construction entity) {
        AddressDTO addressDTO = null;
        if (entity.getAddress() != null) {
            addressDTO = AddressMapper.convertAddressEntityToDTO(entity.getAddress());
        }

        return new ConstructionDTO(
                entity.getId(),
                addressDTO,
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getConstructionStatus(),
                entity.getEstimatedCost()
        );
    }
}