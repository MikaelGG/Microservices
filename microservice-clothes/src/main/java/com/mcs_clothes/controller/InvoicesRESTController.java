package com.mcs_clothes.controller;

import com.mcs_clothes.dto.InvoicesDTO;
import com.mcs_clothes.model.InvoicesModel;
import com.mcs_clothes.services.InvoicesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes-invoices")
public class InvoicesRESTController {

    @Autowired
    InvoicesServices invoicesServices;

    @PostMapping
    public ResponseEntity<InvoicesModel> saveInvoice(@RequestBody InvoicesModel invoicesModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoicesServices.saveInvoice(invoicesModel));
    }

    @GetMapping
    public ResponseEntity<List<InvoicesDTO>> getAllInvoices() {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesServices.getAllInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoicesDTO> getInvoiceById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesServices.getInvoiceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoicesModel> updateInvoice(@PathVariable Long id, @RequestBody InvoicesModel invoicesModel) {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesServices.updateInvoice(id, invoicesModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(invoicesServices.deleteInvoice(id));
    }

}
