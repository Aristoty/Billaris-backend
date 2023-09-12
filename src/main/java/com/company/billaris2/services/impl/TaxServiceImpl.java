package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.TaxDTO;
import com.company.billaris2.entities.Tax;
import com.company.billaris2.repositories.TaxRepository;
import com.company.billaris2.services.interfaces.TaxService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaxServiceImpl implements TaxService {

    private final TaxRepository taxRepository;
    private final ModelMapper modelMapper;

    @Override
    public Tax createTax(TaxDTO taxDTO) {
        Tax tax = modelMapper.map(taxDTO, Tax.class);
        return taxRepository.save(tax);
    }

    @Override
    public Tax getTaxById(Long id) {
        return taxRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }

    @Override
    public Tax updateTax(Long id, TaxDTO taxDTO) {
        Optional<Tax> optionalTax = taxRepository.findById(id);
        if (optionalTax.isPresent()) {
            Tax existingTax = optionalTax.get();
            modelMapper.map(taxDTO, existingTax);
            return taxRepository.save(existingTax);
        }
        return null;
    }

    @Override
    public void deleteTax(Long id) {
        taxRepository.deleteById(id);
    }
}
