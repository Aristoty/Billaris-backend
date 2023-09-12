package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.TaxDTO;
import com.company.billaris2.entities.Tax;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaxService {

    Tax createTax(TaxDTO dto);
    Tax getTaxById(Long id);
    List<Tax> getAllTaxes();
    Tax updateTax(Long id, TaxDTO taxDTO);
    void deleteTax(Long id);
}
