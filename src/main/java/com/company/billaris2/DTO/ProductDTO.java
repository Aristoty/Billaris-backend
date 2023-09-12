package com.company.billaris2.DTO;


import com.company.billaris2.models.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDTO {


    private String name;
    private String description;
    private BigDecimal unitPrice;
    private CategoryDTO category;
    private ProductStatus status;


}
