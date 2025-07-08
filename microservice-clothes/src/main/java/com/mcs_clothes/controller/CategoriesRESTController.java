package com.mcs_clothes.controller;

import com.mcs_clothes.model.CategoriesModel;
import com.mcs_clothes.services.CategoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesRESTController {

    @Autowired
    CategoriesServices categoriesServices;

    @PostMapping
    public ResponseEntity<CategoriesModel> saveCategory(@RequestBody CategoriesModel categoriesModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriesServices.saveCategory(categoriesModel));
    }

    @GetMapping
    public ResponseEntity<List<CategoriesModel>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriesServices.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriesModel> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriesServices.getCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriesModel> updateCategory(@PathVariable Long id, @RequestBody CategoriesModel categoriesModel) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriesServices.updateCategory(id, categoriesModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriesServices.deleteCategory(id));
    }

}
