package com.company.billaris2.DTO;

import com.company.billaris2.entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class InvoiceDTO {


    private Long id;
    private String invoiceNumber;
    private BigDecimal totalAmount;
//    private Long addressId;
    private Long taxId;
    private Long discountId;
    private Long clientId;
    private Long statusId;
    private Long paymentMethodId;
    private Long invoiceLineId;



}




