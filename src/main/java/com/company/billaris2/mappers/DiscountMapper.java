package com.company.billaris2.mappers;

import com.company.billaris2.DTO.DiscountDTO;
import com.company.billaris2.entities.Discount;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {

    public DiscountDTO toDTO(Discount discount) {
        DiscountDTO dto = new DiscountDTO();
//        dto.setId(discount.getId());
        dto.setName(discount.getName());
        dto.setAmountOrPercentage(discount.getAmountOrPercentage());
        dto.setDescription(discount.getDescription());
        return dto;
    }

    public Discount toEntity(DiscountDTO dto) {
        Discount discount = new Discount();
//        discount.setId(dto.getId());
        discount.setName(dto.getName());
        discount.setAmountOrPercentage(dto.getAmountOrPercentage());
        discount.setDescription(dto.getDescription());
        return discount;
    }
}
