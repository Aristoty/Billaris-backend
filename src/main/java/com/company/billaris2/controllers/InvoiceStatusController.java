package com.company.billaris2.controllers;

import com.company.billaris2.DTO.InvoiceStatusDTO;
import com.company.billaris2.entities.InvoiceStatus;
import com.company.billaris2.services.interfaces.InvoiceStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-status")
@RequiredArgsConstructor
public class InvoiceStatusController {

    private final InvoiceStatusService invoiceStatusService;

    @PostMapping
    public ResponseEntity<InvoiceStatus> createInvoiceStatus(@RequestBody InvoiceStatusDTO invoiceStatusDTO){
        InvoiceStatus createdInvoiceStatus = invoiceStatusService.createInvoiceStatus(invoiceStatusDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoiceStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceStatus> getInvoiceStatusById(@PathVariable Long id){
        InvoiceStatus invoiceStatus = invoiceStatusService.getInvoiceStatusById(id);
        if (invoiceStatus != null){
            return ResponseEntity.ok(invoiceStatus);
        } else {
           return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<InvoiceStatus>> getAllInvoiceStatuses(){
        List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getAllInvoiceStatuses();
        return ResponseEntity.ok(invoiceStatuses);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<InvoiceStatus> updateInvoiceStatus(@PathVariable Long id, @RequestBody InvoiceStatusDTO invoiceStatusDTO){
        InvoiceStatus updatedInvoiceStatus = invoiceStatusService.updateInvoiceStatus(id, invoiceStatusDTO);
        if(updatedInvoiceStatus != null){
            return ResponseEntity.ok(updatedInvoiceStatus);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceStatus(@PathVariable Long id){
        invoiceStatusService.deleteInvoiceStatus(id);
        return ResponseEntity.noContent().build();
    }
}

