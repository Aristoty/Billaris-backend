package com.company.billaris2.mappers;

import com.company.billaris2.DTO.InvoiceStatusDTO;
import com.company.billaris2.entities.InvoiceStatus;
import org.springframework.stereotype.Component;

@Component
public class InvoiceStatusMapper {
    public InvoiceStatusDTO toDTO(InvoiceStatus status) {
        InvoiceStatusDTO dto = new InvoiceStatusDTO();
//        dto.setId(status.getId());
        dto.setName(status.getName());
        dto.setDescription(status.getDescription());
        return dto;
    }

    public InvoiceStatus toEntity(InvoiceStatusDTO dto) {
        InvoiceStatus status = new InvoiceStatus();
//        status.setId(dto.getId());
        status.setName(dto.getName());
        status.setDescription(dto.getDescription());
        return status;
    }
}
