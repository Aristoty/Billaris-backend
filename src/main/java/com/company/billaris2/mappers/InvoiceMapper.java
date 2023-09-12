package com.company.billaris2.mappers;

import com.company.billaris2.DTO.InvoiceDTO;
import com.company.billaris2.entities.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class InvoiceMapper {
//
//    private final AddressMapper addressMapper;
//    private final TaxMapper taxMapper;
//    private final DiscountMapper discountMapper;
//    private final ClientMapper clientMapper;
//    private final InvoiceStatusMapper invoiceStatusMapper;
//    private final PaymentMethodMapper paymentMethodMapper;
//    private final InvoiceLineMapper invoiceLineMapper;
//    private final InvoiceHistoryMapper invoiceHistoryMapper;
//
//
//    public InvoiceDTO toDTO(Invoice invoice) {
//        InvoiceDTO dto = new InvoiceDTO();
//        dto.setId(invoice.getId());
//        dto.setInvoiceNumber(invoice.getInvoiceNumber());
//        dto.setInvoiceDate(invoice.getInvoiceDate());
//        dto.setTotalAmount(invoice.getTotalAmount());
//        dto.setAddress(addressMapper.toDTO(invoice.getAddress()));
//        dto.setTax(taxMapper.toDTO(invoice.getTax()));
//        dto.setDiscount(discountMapper.toDTO(invoice.getDiscount()));
//        dto.setClient(clientMapper.toDTO(invoice.getClient()));
//        dto.setStatus(invoiceStatusMapper.toDTO(invoice.getStatus()));
//        dto.setPaymentMethod(paymentMethodMapper.toDTO(invoice.getPaymentMethod()));
////        dto.setInvoiceLines(invoiceLineMapper.toDTOList(invoice.getInvoiceLines()));
////        dto.setInvoiceHistories(invoiceHistoryMapper.toDTOList(invoice.getInvoiceHistories()));
//        return dto;
//    }
//
//    public Invoice toEntity(InvoiceDTO dto) {
//        Invoice invoice = new Invoice();
////        invoice.setId(dto.getId());
//        invoice.setInvoiceNumber(dto.getInvoiceNumber());
//        invoice.setInvoiceDate(dto.getInvoiceDate());
//        invoice.setTotalAmount(dto.getTotalAmount());
//        invoice.setAddress(addressMapper.toEntity(dto.getAddress()));
////        invoice.setTax(taxMapper.toEntity(dto.getTax()));
//        invoice.setDiscount(discountMapper.toEntity(dto.getDiscount()));
//        invoice.setClient(clientMapper.toEntity(dto.getClient()));
////        invoice.setStatus(invoiceStatusMapper.toEntity(dto.getStatus()));
////        invoice.setPaymentMethod(paymentMethodMapper.toEntity(dto.getPaymentMethod()));
////        invoice.setInvoiceLines(invoiceLineMapper.toEntityList(dto.getInvoiceLines()));
//
//        return invoice;
//    }
}
