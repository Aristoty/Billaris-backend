package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.InvoiceLineDTO;
import com.company.billaris2.entities.InvoiceLine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceLineService {
    InvoiceLine createInvoiceLine(InvoiceLineDTO invoiceLineDTO);

    InvoiceLine getInvoiceLineById(Long id);

    List<InvoiceLine> getAllInvoiceLines();

    InvoiceLine updateInvoiceLine(Long id, InvoiceLineDTO invoiceLineDTO);

    void deleteInvoiceLine(Long id);
}
