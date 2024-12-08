package unifacef.edu.api_financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.mappers.InvoiceMapper;
import unifacef.edu.api_financeiro.models.dto.InvoicesCreateDTO;
import unifacef.edu.api_financeiro.models.dto.InvoicesDTO;
import unifacef.edu.api_financeiro.models.entity.Invoice;
import unifacef.edu.api_financeiro.repository.ExpenseRepository;
import unifacef.edu.api_financeiro.repository.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoicesRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    public Invoice save(Invoice invoice) {
        return invoicesRepository.save(invoice);
    }

    @Transactional
    public InvoicesDTO createInvoice(InvoicesCreateDTO invoiceDTO) {
        Invoice invoice = InvoiceMapper.convertInvoiceCreateDTOIntoInvoice(invoiceDTO);
        invoice = save(invoice);
        return InvoiceMapper.convertInvoiceEntityToDTO(invoice);
    }

    public List<InvoicesDTO> getAllInvoices() {
        return InvoiceMapper.convertListOfInvoiceIntoListOfInvoiceDTO(invoicesRepository.findAll());
    }

    public InvoicesDTO getInvoiceById(Integer id) {
        Invoice invoice = OptionalHelper.getOptionalEntity(invoicesRepository.findById(id));
        return InvoiceMapper.convertInvoiceEntityToDTO(invoice);
    }

    @Transactional
    public InvoicesDTO updateInvoice(Integer id, InvoicesCreateDTO invoiceDTO) {
        Invoice existingInvoice = OptionalHelper.getOptionalEntity(invoicesRepository.findById(id));

        InvoiceMapper.updateInvoice(invoiceDTO, existingInvoice);

        Invoice updatedInvoice = invoicesRepository.save(existingInvoice);

        return InvoiceMapper.convertInvoiceEntityToDTO(updatedInvoice);
    }

    @Transactional
    public void deleteInvoice(Integer id) {
        Invoice invoice = OptionalHelper.getOptionalEntity(invoicesRepository.findById(id));
        invoicesRepository.delete(invoice);
    }
}
