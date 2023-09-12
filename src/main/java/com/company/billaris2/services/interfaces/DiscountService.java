package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.DiscountDTO;
import com.company.billaris2.entities.Discount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DiscountService {
    Discount createDiscount(DiscountDTO discountDTO);

    Discount getDiscountById(Long discountId);

    List<Discount> getAllDiscounts();

    Discount updateDiscount(Long id, DiscountDTO discountDTO);

    void deleteDiscount(Long id);
}
