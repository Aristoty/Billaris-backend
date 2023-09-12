package com.company.billaris2.mappers;

import com.company.billaris2.DTO.InvoiceLineDTO;
import com.company.billaris2.entities.InvoiceLine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceLineMapper {

    private final ProductMapper productMapper;

    public InvoiceLineDTO toDTO(InvoiceLine invoiceLine) {
        InvoiceLineDTO dto = new InvoiceLineDTO();
//        dto.setId(invoiceLine.getId());
        dto.setQuantity(invoiceLine.getQuantity());
        dto.setUnitPrice(invoiceLine.getUnitPrice());
        dto.setSubtotal(invoiceLine.getSubtotal());
//        dto.setProduct(productMapper.toDTO(invoiceLine.getProduct()));
        return dto;
    }

    public InvoiceLine toEntity(InvoiceLineDTO dto) {
        InvoiceLine invoiceLine = new InvoiceLine();
//        invoiceLine.setId(dto.getId());
        invoiceLine.setQuantity(dto.getQuantity());
        invoiceLine.setUnitPrice(dto.getUnitPrice());
        invoiceLine.setSubtotal(dto.getSubtotal());
//        invoiceLine.setProduct(productMapper.toEntity(dto.getProduct()));
        return invoiceLine;
    }
}
