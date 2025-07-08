package com.microservice_client.controller;

import com.microservice_client.model.ClientModel;
import com.microservice_client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientRESTController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody ClientModel clientModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientModel));
    }

    @GetMapping
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientModel clientModel) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id, clientModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.deleteClient(id));
    }

}
