package com.company.billaris2.mappers;

import com.company.billaris2.DTO.TaxDTO;
import com.company.billaris2.entities.Tax;
import org.springframework.stereotype.Component;

@Component
public class TaxMapper {

    public TaxDTO toDTO(Tax tax) {
        TaxDTO dto = new TaxDTO();
//        dto.setId(tax.getId());
        dto.setName(tax.getName());
        dto.setTaxRate(tax.getTaxRate());
        dto.setDescription(tax.getDescription());
        return dto;
    }

    public Tax toEntity(TaxDTO dto) {
        Tax tax = new Tax();
//        tax.setId(dto.getId());
        tax.setName(dto.getName());
        tax.setTaxRate(dto.getTaxRate());
        tax.setDescription(dto.getDescription());
        return tax;
    }
}
