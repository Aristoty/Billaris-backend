package com.company.billaris2.controllers;

import com.company.billaris2.DTO.InvoiceHistoryDTO;
import com.company.billaris2.entities.InvoiceHistory;
import com.company.billaris2.services.interfaces.InvoiceHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-histories")
@RequiredArgsConstructor
public class InvoiceHistoryController {

    private final InvoiceHistoryService invoiceHistoryService;


    @PostMapping
    public ResponseEntity<InvoiceHistory> createInvoiceHistory(@RequestBody InvoiceHistoryDTO invoiceHistoryDTO) {
        InvoiceHistory createdInvoiceHistory = invoiceHistoryService.createInvoiceHistory(invoiceHistoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoiceHistory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceHistory> getInvoiceHistoryById(@PathVariable Long id) {
        InvoiceHistory invoiceHistory = invoiceHistoryService.getInvoiceHistoryById(id);
        if (invoiceHistory != null) {
            return ResponseEntity.ok(invoiceHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<InvoiceHistory>> getAllInvoiceHistories() {
        List<InvoiceHistory> invoiceHistories = invoiceHistoryService.getAllInvoiceHistories();
        return ResponseEntity.ok(invoiceHistories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceHistory> updateInvoiceHistory(@PathVariable Long id, @RequestBody InvoiceHistoryDTO invoiceHistoryDTO) {
        InvoiceHistory updatedInvoiceHistory = invoiceHistoryService.updateInvoiceHistory(id, invoiceHistoryDTO);
        if (updatedInvoiceHistory != null) {
            return ResponseEntity.ok(updatedInvoiceHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceHistory(@PathVariable Long id) {
        invoiceHistoryService.deleteInvoiceHistory(id);
        return ResponseEntity.noContent().build();
    }
}


