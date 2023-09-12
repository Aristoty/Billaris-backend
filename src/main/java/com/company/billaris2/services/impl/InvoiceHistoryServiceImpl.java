package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.InvoiceHistoryDTO;
import com.company.billaris2.entities.InvoiceHistory;
import com.company.billaris2.repositories.InvoiceHistoryRepository;
import com.company.billaris2.services.interfaces.InvoiceHistoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceHistoryServiceImpl implements InvoiceHistoryService {

    private final InvoiceHistoryRepository invoiceHistoryRepository;
    private final ModelMapper modelMapper;



    @Override
    public InvoiceHistory createInvoiceHistory(InvoiceHistoryDTO invoiceHistoryDTO) {
        InvoiceHistory invoiceHistory = modelMapper.map(invoiceHistoryDTO, InvoiceHistory.class);
        return invoiceHistoryRepository.save(invoiceHistory);
    }

    @Override
    public InvoiceHistory getInvoiceHistoryById(Long id) {
        return invoiceHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<InvoiceHistory> getAllInvoiceHistories() {
        return invoiceHistoryRepository.findAll();
    }

    @Override
    public InvoiceHistory updateInvoiceHistory(Long id, InvoiceHistoryDTO invoiceHistoryDTO) {
        Optional<InvoiceHistory> optionalInvoiceHistory = invoiceHistoryRepository.findById(id);
        if (optionalInvoiceHistory.isPresent()) {
            InvoiceHistory existingInvoiceHistory = optionalInvoiceHistory.get();
            modelMapper.map(invoiceHistoryDTO, existingInvoiceHistory);
            return invoiceHistoryRepository.save(existingInvoiceHistory);
        }
        return null;
    }

    @Override
    public void deleteInvoiceHistory(Long id) {
        invoiceHistoryRepository.deleteById(id);
    }
}
