package com.microservice_webs.controller;

import com.microservice_webs.model.Developers;
import com.microservice_webs.service.DevelopersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DevelopersRESTController {

    @Autowired
    DevelopersService developersService;

    @PostMapping
    public ResponseEntity<Developers> saveDeveloper(@RequestBody Developers developer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(developersService.saveDeveloper(developer));
    }

    @GetMapping
    public ResponseEntity<List<Developers>> getAllDevelopers() {
        return ResponseEntity.status(HttpStatus.OK).body(developersService.getAllDevelopers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developers> getDeveloperById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(developersService.getDeveloperById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developers> updateDeveloper(@PathVariable Long id, @RequestBody Developers developer) {
        return ResponseEntity.status(HttpStatus.OK).body(developersService.updateDeveloper(id, developer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(developersService.deleteDeveloper(id));
    }

}
