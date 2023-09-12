package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.InvoiceDTO;
import com.company.billaris2.entities.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceService {

    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    Invoice createInvoice(InvoiceDTO invoiceDTO);
    Invoice updateInvoice(Long id, InvoiceDTO invoiceDTO);
    void deleteInvoice(Long id);
}
