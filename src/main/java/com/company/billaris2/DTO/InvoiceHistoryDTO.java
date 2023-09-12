package com.company.billaris2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class InvoiceHistoryDTO {


    private String actionDate;
    private String actionDescription;
    private Long userId;
    private Long invoiceId;

}
