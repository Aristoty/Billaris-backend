package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.PaymentMethodDTO;
import com.company.billaris2.entities.PaymentMethod;
import com.company.billaris2.repositories.PaymentMethodRepository;
import com.company.billaris2.services.interfaces.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    private final ModelMapper modelMapper;



    @Override
    public PaymentMethod createPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod paymentMethod = modelMapper.map(paymentMethodDTO, PaymentMethod.class);
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethodDTO paymentMethodDTO) {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);
        if (optionalPaymentMethod.isPresent()) {
            PaymentMethod existingPaymentMethod = optionalPaymentMethod.get();
            modelMapper.map(paymentMethodDTO, existingPaymentMethod);
            return paymentMethodRepository.save(existingPaymentMethod);
        }
        return null;
    }

    @Override
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }
}
