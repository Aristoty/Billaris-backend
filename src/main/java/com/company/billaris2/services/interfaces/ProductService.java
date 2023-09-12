package com.company.billaris2.services.interfaces;


import com.company.billaris2.DTO.ProductDTO;
import com.company.billaris2.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(ProductDTO dto) ;
    Product updateProduct(Long id, ProductDTO dto) ;
    void deleteProduct(Long id);

}
