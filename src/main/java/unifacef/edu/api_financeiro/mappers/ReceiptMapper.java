package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.ReceiptCreateDTO;
import unifacef.edu.api_financeiro.models.dto.ReceiptDTO;
import unifacef.edu.api_financeiro.models.entity.Receipt;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReceiptMapper {
    public static Receipt convertReceiptDTOIntoReceipt(ReceiptCreateDTO receiptDTO) {
        return new Receipt(
                DonationMapper.convertDonationDTOIntoDonation(receiptDTO.getDonation()),
                SaleMapper.convertSaleCreateDTOIntoSale(receiptDTO.getSale()),
                RebateMapper.convertRebateCreateDTOIntoRebate(receiptDTO.getRebate())
        );
    }

    public static ReceiptDTO convertReceiptIntoReceiptDTO(Receipt receipt) {
        return new ReceiptDTO(
                receipt.getId(),
                DonationMapper.convertDonationIntoDonationDTO(receipt.getDonation()),
                SaleMapper.convertSaleIntoSaleDTO(receipt.getSale()),
                RebateMapper.convertRebateIntoRebateDTO(receipt.getRebate()),
                receipt.getReceiptDate(),
                receipt.getExpiryDate()
        );
    }

    public static List<ReceiptDTO> convertListOfReceiptIntoListOfReceiptDTO(List<Receipt> receipts) {
        List<ReceiptDTO> receiptDTOs = new ArrayList<>();
        for (Receipt receipt : receipts) {
            receiptDTOs.add(convertReceiptIntoReceiptDTO(receipt));
        }
        return receiptDTOs;
    }

    public static void updateReceipt(ReceiptCreateDTO receiptUpdate, Receipt receipt) {
        receipt.setDonation(DonationMapper.convertDonationDTOIntoDonation(receiptUpdate.getDonation()));
        receipt.setSale(SaleMapper.convertSaleCreateDTOIntoSale(receiptUpdate.getSale()));
        receipt.setRebate(RebateMapper.convertRebateCreateDTOIntoRebate(receiptUpdate.getRebate()));
        receipt.setReceiptDate(receiptUpdate.getReceiptDate());
        receipt.setExpiryDate(receiptUpdate.getExpiryDate());
    }

}
