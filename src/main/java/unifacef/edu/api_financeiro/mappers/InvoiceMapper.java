package unifacef.edu.api_financeiro.mappers;

import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.models.dto.InvoicesCreateDTO;
import unifacef.edu.api_financeiro.models.dto.InvoicesDTO;
import unifacef.edu.api_financeiro.models.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceMapper {
    public static Invoice convertInvoiceCreateDTOIntoInvoice(InvoicesCreateDTO dto) {
        return new Invoice(
                MovementMapper.convertMovementDTOIntoMovement(dto.getMovement()),
                dto.getInvoicePhoto()
        );
    }

    public static InvoicesDTO convertInvoiceEntityToDTO(Invoice invoice) {
        return new InvoicesDTO(
                invoice.getId(),
                MovementMapper. convertMovementIntoMovementDTO(invoice.getMovement()),
                invoice.getInvoicePhoto()
        );
    }

    public static List<InvoicesDTO> convertListOfInvoiceIntoListOfInvoiceDTO(List<Invoice> invoices) {
        List<InvoicesDTO> invoiceDTOs = new ArrayList<>();
        for (Invoice invoice : invoices) {
            invoiceDTOs.add(convertInvoiceEntityToDTO(invoice));
        }
        return invoiceDTOs;
    }

    public static void updateInvoice(InvoicesCreateDTO invoiceUpdate, Invoice invoice) {
        invoice.setMovement(MovementMapper.convertMovementDTOIntoMovement(invoiceUpdate.getMovement()));
        invoice.setInvoicePhoto(invoiceUpdate.getInvoicePhoto());
    }


}