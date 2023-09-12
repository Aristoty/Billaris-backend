package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.PaymentMethodDTO;
import com.company.billaris2.entities.PaymentMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaymentMethodService {
    PaymentMethod createPaymentMethod(PaymentMethodDTO paymentMethodDTO);

    PaymentMethod getPaymentMethodById(Long paymentMethodId);

    List<PaymentMethod> getAllPaymentMethods();

    PaymentMethod updatePaymentMethod(Long id, PaymentMethodDTO paymentMethodDTO);

    void deletePaymentMethod(Long id);
}
