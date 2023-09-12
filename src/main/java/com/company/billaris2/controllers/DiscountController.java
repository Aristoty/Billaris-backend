package com.company.billaris2.controllers;

import com.company.billaris2.DTO.DiscountDTO;
import com.company.billaris2.entities.Discount;
import com.company.billaris2.services.interfaces.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;


    @PostMapping
    public ResponseEntity<Discount> createDiscount(@RequestBody DiscountDTO discountDTO) {
        Discount createdDiscount = discountService.createDiscount(discountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> getDiscountById(@PathVariable Long id) {
        Discount discount = discountService.getDiscountById(id);
        if (discount != null) {
            return ResponseEntity.ok(discount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Discount>> getAllDiscounts() {
        List<Discount> discounts = discountService.getAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable Long id, @RequestBody DiscountDTO discountDTO) {
        Discount updatedDiscount = discountService.updateDiscount(id, discountDTO);
        if (updatedDiscount != null) {
            return ResponseEntity.ok(updatedDiscount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
        discountService.deleteDiscount(id);
        return ResponseEntity.noContent().build();
    }
}