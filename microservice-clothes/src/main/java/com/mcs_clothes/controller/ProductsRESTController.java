package com.mcs_clothes.controller;

import com.mcs_clothes.model.ProductsModel;
import com.mcs_clothes.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsRESTController {

    @Autowired
    ProductsServices productsServices;

    @PostMapping
    public ResponseEntity<ProductsModel> saveProduct(@RequestBody ProductsModel product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productsServices.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductsModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productsServices.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsModel> getProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productsServices.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsModel> updateProduct(@PathVariable Long id, @RequestBody ProductsModel product) {
        return ResponseEntity.status(HttpStatus.OK).body(productsServices.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productsServices.deleteProduct(id));
    }

}
