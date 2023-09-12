package com.company.billaris2.controllers;

import com.company.billaris2.DTO.TaxDTO;
import com.company.billaris2.entities.Tax;
import com.company.billaris2.services.interfaces.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxes")
public class TaxController {

    private final TaxService taxService;

    @Autowired
    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public ResponseEntity<Tax> createTax(@RequestBody TaxDTO taxDTO) {
        Tax createdTax = taxService.createTax(taxDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTax);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tax> getTaxById(@PathVariable Long id) {
        Tax tax = taxService.getTaxById(id);
        if (tax != null) {
            return ResponseEntity.ok(tax);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tax>> getAllTaxes() {
        List<Tax> taxes = taxService.getAllTaxes();
        return ResponseEntity.ok(taxes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tax> updateTax(@PathVariable Long id, @RequestBody TaxDTO taxDTO) {
        Tax updatedTax = taxService.updateTax(id, taxDTO);
        if (updatedTax != null) {
            return ResponseEntity.ok(updatedTax);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTax(@PathVariable Long id) {
        taxService.deleteTax(id);
        return ResponseEntity.noContent().build();
    }
}
