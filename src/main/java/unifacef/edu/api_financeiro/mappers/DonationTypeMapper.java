package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.DonationTypeDTO;
import unifacef.edu.api_financeiro.models.entity.DonationType;

@Component
public class DonationTypeMapper {
    public static DonationType convertDonationTypeCreateDTOIntoDonationType(DonationTypeDTO donationTypeCreate) {
        return new DonationType(donationTypeCreate.getTypeDonationName());
    }

    public static DonationTypeDTO convertDonationTypeIntoDonationTypeDTO(DonationType donationType) {
        return new DonationTypeDTO(donationType.getId(), donationType.getTypeDonationName());
    }

    public static DonationType convertDonationTypeDTOIntoDonationType(DonationTypeDTO donationType) {
        return new DonationType(donationType.getTypeDonationName());
    }
}
