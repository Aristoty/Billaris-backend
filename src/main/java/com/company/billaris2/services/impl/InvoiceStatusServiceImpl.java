package com.company.billaris2.services.impl;


import com.company.billaris2.DTO.InvoiceStatusDTO;
import com.company.billaris2.entities.InvoiceStatus;
import com.company.billaris2.repositories.InvoiceStatusRepository;
import com.company.billaris2.services.interfaces.InvoiceStatusService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceStatusServiceImpl implements InvoiceStatusService {

    private final InvoiceStatusRepository invoiceStatusRepository;
    private final ModelMapper modelMapper;



    @Override
    public InvoiceStatus createInvoiceStatus(InvoiceStatusDTO invoiceStatusDTO) {
        InvoiceStatus invoiceStatus = modelMapper.map(invoiceStatusDTO, InvoiceStatus.class);
        return invoiceStatusRepository.save(invoiceStatus);
    }

    @Override
    public InvoiceStatus getInvoiceStatusById(Long id) {
        return invoiceStatusRepository.findById(id).orElse(null);
    }

    @Override
    public List<InvoiceStatus> getAllInvoiceStatuses() {
        return invoiceStatusRepository.findAll();
    }

    @Override
    public InvoiceStatus updateInvoiceStatus(Long id, InvoiceStatusDTO invoiceStatusDTO) {
        Optional<InvoiceStatus> optionalInvoiceStatus = invoiceStatusRepository.findById(id);
        if (optionalInvoiceStatus.isPresent()) {
            InvoiceStatus existingInvoiceStatus = optionalInvoiceStatus.get();
            modelMapper.map(invoiceStatusDTO, existingInvoiceStatus);
            return invoiceStatusRepository.save(existingInvoiceStatus);
        }
        return null;
    }

    @Override
    public void deleteInvoiceStatus(Long id) {
        invoiceStatusRepository.deleteById(id);
    }
}
