package unifacef.edu.api_financeiro.mappers;

import unifacef.edu.api_financeiro.models.dto.AddressDTO;
import unifacef.edu.api_financeiro.models.entity.Address;

public class AddressMapper {
    public static Address convertAddressDTOToEntity(AddressDTO dto) {
        return new Address(
                dto.getId(),
                dto.getCep(),
                dto.getStreet(),
                dto.getNumber(),
                dto.getNeighborhood(),
                dto.getComplement()
        );
    }

    public static AddressDTO convertAddressEntityToDTO(Address entity) {
        return new AddressDTO(
                entity.getId(),
                entity.getCep(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getNeighborhood(),
                entity.getComplement()
        );
    }
}
