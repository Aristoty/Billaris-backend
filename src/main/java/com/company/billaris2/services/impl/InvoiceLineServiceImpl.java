package com.company.billaris2.services.impl;


import com.company.billaris2.DTO.InvoiceLineDTO;
import com.company.billaris2.entities.InvoiceLine;
import com.company.billaris2.repositories.InvoiceLineRepository;
import com.company.billaris2.services.interfaces.InvoiceLineService;
import com.company.billaris2.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceLineServiceImpl implements InvoiceLineService {

    private final InvoiceLineRepository invoiceLineRepository;
    private final ModelMapper modelMapper;
    private final ProductService productService;



    @Override
    public InvoiceLine createInvoiceLine(InvoiceLineDTO invoiceLineDTO) {
        InvoiceLine invoiceLine = modelMapper.map(invoiceLineDTO, InvoiceLine.class);

        invoiceLine.setProduct(productService.getProductById(invoiceLineDTO.getProductId()));

        return invoiceLineRepository.save(invoiceLine);
    }

    @Override
    public InvoiceLine getInvoiceLineById(Long id) {
        return invoiceLineRepository.findById(id).orElse(null);
    }

    @Override
    public List<InvoiceLine> getAllInvoiceLines() {
        return invoiceLineRepository.findAll();
    }

    @Override
    public InvoiceLine updateInvoiceLine(Long id, InvoiceLineDTO invoiceLineDTO) {
        Optional<InvoiceLine> optionalInvoiceLine = invoiceLineRepository.findById(id);
        if (optionalInvoiceLine.isPresent()) {
            InvoiceLine existingInvoiceLine = optionalInvoiceLine.get();
            modelMapper.map(invoiceLineDTO, existingInvoiceLine);
            return invoiceLineRepository.save(existingInvoiceLine);
        }
        return null;
    }

    @Override
    public void deleteInvoiceLine(Long id) {
        invoiceLineRepository.deleteById(id);
    }
}