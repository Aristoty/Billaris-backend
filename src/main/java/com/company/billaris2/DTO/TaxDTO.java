package com.company.billaris2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TaxDTO {


    private String name;
    private BigDecimal taxRate;
    private String description;
}
