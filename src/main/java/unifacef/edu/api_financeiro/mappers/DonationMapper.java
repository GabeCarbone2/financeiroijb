package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.DonationDTO;
import unifacef.edu.api_financeiro.models.entity.Donation;

@Component
public class DonationMapper {
    public static Donation convertDonationCreateDTOIntoDonation(DonationDTO donationCreate) {
        return new Donation(DonationTypeMapper.convertDonationTypeCreateDTOIntoDonationType(donationCreate
                .getDonationType()));
    }

    public static DonationDTO convertDonationIntoDonationDTO(Donation donation) {
        return new DonationDTO(donation.getId(),
                DonationTypeMapper.convertDonationTypeIntoDonationTypeDTO(donation.getDonationType()));
    }

    public static Donation convertDonationDTOIntoDonation(DonationDTO donation) {
        return new Donation(DonationTypeMapper.convertDonationTypeDTOIntoDonationType(donation.getDonationType()));
    }
}