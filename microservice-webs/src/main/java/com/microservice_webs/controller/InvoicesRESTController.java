package com.microservice_webs.controller;

import com.microservice_webs.dto.InvoicesDTO;
import com.microservice_webs.model.Invoices;
import com.microservice_webs.service.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/webs-invoices")
public class InvoicesRESTController {

    @Autowired
    InvoicesService invoicesService;

    @PostMapping
    public ResponseEntity<Invoices> saveInvoice(@RequestBody Invoices invoice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoicesService.saveInvoice(invoice));
    }

    @GetMapping
    public ResponseEntity<List<InvoicesDTO>> getInvoices() {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesService.getInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoicesDTO> getInvoiceById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesService.getInvoiceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoices> updateInvoice(@PathVariable Long id, @RequestBody Invoices invoice) {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesService.updateInvoice(id, invoice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesService.deleteInvoice(id));
    }

}
