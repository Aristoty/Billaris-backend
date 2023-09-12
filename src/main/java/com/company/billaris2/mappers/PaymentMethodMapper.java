package com.company.billaris2.mappers;

import com.company.billaris2.DTO.PaymentMethodDTO;
import com.company.billaris2.entities.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodMapper {

    public PaymentMethodDTO toDTO(PaymentMethod paymentMethod) {
        PaymentMethodDTO dto = new PaymentMethodDTO();
//        dto.setId(paymentMethod.getId());
        dto.setName(paymentMethod.getName());
        dto.setDescription(paymentMethod.getDescription());
        return dto;
    }

    public PaymentMethod toEntity(PaymentMethodDTO dto) {
        PaymentMethod paymentMethod = new PaymentMethod();
//        paymentMethod.setId(dto.getId());
        paymentMethod.setName(dto.getName());
        paymentMethod.setDescription(dto.getDescription());
        return paymentMethod;
    }
}
