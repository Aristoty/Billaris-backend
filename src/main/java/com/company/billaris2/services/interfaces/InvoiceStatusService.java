package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.InvoiceStatusDTO;
import com.company.billaris2.entities.InvoiceStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceStatusService {
    InvoiceStatus createInvoiceStatus(InvoiceStatusDTO invoiceStatusDTO);

    InvoiceStatus getInvoiceStatusById(Long statusId);

    List<InvoiceStatus> getAllInvoiceStatuses();

    InvoiceStatus updateInvoiceStatus(Long id, InvoiceStatusDTO invoiceStatusDTO);

    void deleteInvoiceStatus(Long id);
}
