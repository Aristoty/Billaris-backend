package com.company.billaris2.controllers;

import com.company.billaris2.DTO.InvoiceLineDTO;
import com.company.billaris2.entities.InvoiceLine;
import com.company.billaris2.services.interfaces.InvoiceLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-lines")
@RequiredArgsConstructor
public class InvoiceLineController {

    private final InvoiceLineService invoiceLineService;

    @PostMapping
    public ResponseEntity<InvoiceLine> createInvoiceLine(@RequestBody InvoiceLineDTO invoiceLineDTO) {
        InvoiceLine createdInvoiceLine = invoiceLineService.createInvoiceLine(invoiceLineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoiceLine);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceLine> getInvoiceLineById(@PathVariable Long id) {
        InvoiceLine invoiceLine = invoiceLineService.getInvoiceLineById(id);
        if (invoiceLine != null) {
            return ResponseEntity.ok(invoiceLine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<InvoiceLine>> getAllInvoiceLines() {
        List<InvoiceLine> invoiceLines = invoiceLineService.getAllInvoiceLines();
        return ResponseEntity.ok(invoiceLines);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceLine> updateInvoiceLine(@PathVariable Long id, @RequestBody InvoiceLineDTO invoiceLineDTO) {
        InvoiceLine updatedInvoiceLine = invoiceLineService.updateInvoiceLine(id, invoiceLineDTO);
        if (updatedInvoiceLine != null) {
            return ResponseEntity.ok(updatedInvoiceLine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceLine(@PathVariable Long id) {
        invoiceLineService.deleteInvoiceLine(id);
        return ResponseEntity.noContent().build();
    }
}

// Répétez le modèle pour les autres contrôleurs (InvoiceHistoryController, UserController).
