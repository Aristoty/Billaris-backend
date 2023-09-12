package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.DiscountDTO;
import com.company.billaris2.entities.Discount;
import com.company.billaris2.repositories.DiscountRepository;
import com.company.billaris2.services.interfaces.DiscountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final ModelMapper modelMapper;

    @Override
    public Discount createDiscount(DiscountDTO discountDTO) {
        Discount discount = modelMapper.map(discountDTO, Discount.class);
        return discountRepository.save(discount);
    }

    @Override
    public Discount getDiscountById(Long id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    @Override
    public Discount updateDiscount(Long id, DiscountDTO discountDTO) {
        Optional<Discount> optionalDiscount = discountRepository.findById(id);
        if (optionalDiscount.isPresent()) {
            Discount existingDiscount = optionalDiscount.get();
            modelMapper.map(discountDTO, existingDiscount);
            return discountRepository.save(existingDiscount);
        }
        return null;
    }

    @Override
    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }
}
