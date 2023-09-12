package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.InvoiceHistoryDTO;
import com.company.billaris2.entities.InvoiceHistory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceHistoryService {
    InvoiceHistory createInvoiceHistory(InvoiceHistoryDTO invoiceHistoryDTO);

    InvoiceHistory getInvoiceHistoryById(Long id);

    List<InvoiceHistory> getAllInvoiceHistories();

    InvoiceHistory updateInvoiceHistory(Long id, InvoiceHistoryDTO invoiceHistoryDTO);

    void deleteInvoiceHistory(Long id);
}
