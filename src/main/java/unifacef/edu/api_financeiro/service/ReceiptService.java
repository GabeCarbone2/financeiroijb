package unifacef.edu.api_financeiro.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.ReceiptMapper;
import unifacef.edu.api_financeiro.models.dto.ReceiptCreateDTO;
import unifacef.edu.api_financeiro.models.dto.ReceiptDTO;
import unifacef.edu.api_financeiro.models.entity.Receipt;
import unifacef.edu.api_financeiro.repository.ReceiptRepository;

import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    public Receipt save(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Transactional
    public ReceiptDTO createReceipt(ReceiptCreateDTO receiptDTO) {
        Receipt receipt = ReceiptMapper.convertReceiptDTOIntoReceipt(receiptDTO);
        receipt = save(receipt);
        return ReceiptMapper.convertReceiptIntoReceiptDTO(receipt);
    }

    public List<ReceiptDTO> getAllReceipts() {
        return ReceiptMapper.convertListOfReceiptIntoListOfReceiptDTO(receiptRepository.findAll());
    }

    public ReceiptDTO getReceiptById(Integer id) {
        Receipt receipt = OptionalHelper.getOptionalEntity(receiptRepository.findById(id));
        return ReceiptMapper.convertReceiptIntoReceiptDTO(receipt);
    }

    @Transactional
    public ReceiptDTO updateReceipt(Integer id, ReceiptCreateDTO receiptDTO) {
        Receipt existingReceipt = OptionalHelper.getOptionalEntity(receiptRepository.findById(id));
        ReceiptMapper.updateReceipt(receiptDTO, existingReceipt);
        Receipt updatedReceipt = receiptRepository.save(existingReceipt);

        return ReceiptMapper.convertReceiptIntoReceiptDTO(updatedReceipt);
    }

    @Transactional
    public void deleteReceipt(Integer id) {
        Receipt receipt = OptionalHelper.getOptionalEntity(receiptRepository.findById(id));
        receiptRepository.delete(receipt);
    }
}
