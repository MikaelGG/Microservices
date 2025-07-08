package com.mcs_clothes.services;

import com.mcs_clothes.model.CategoriesModel;
import com.mcs_clothes.model.ProductsModel;
import com.mcs_clothes.repository.CategoriesRepository;
import com.mcs_clothes.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsServices {

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CategoriesRepository categoriesRepository;

    @Transactional
    public ProductsModel saveProduct(ProductsModel product) {
        if (productsRepository.existsByName(product.getName())) {
            throw new RuntimeException("Product with name " + product.getName() + " already exists.");
        }
        return productsRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<ProductsModel> getAllProducts() {
        return productsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ProductsModel getProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found."));
    }

    @Transactional
    public ProductsModel updateProduct(Long id, ProductsModel product) {
        ProductsModel productsModel = productsRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found."));
        if (productsRepository.existsByName(product.getName()) && !productsModel.getName().equals(product.getName())) {
            throw new RuntimeException("Product with name " + product.getName() + " already exists.");
        }
        CategoriesModel category = categoriesRepository.findById(product.getCategory().getId()).orElseThrow(() -> new RuntimeException("Category with id " + product.getCategory().getId() + " not found."));
        productsModel.setName(product.getName());
        productsModel.setDescription(product.getDescription());
        productsModel.setQuantity(product.getQuantity());
        productsModel.setPrice(product.getPrice());
        productsModel.setCategory(category);
        return productsRepository.save(productsModel);
    }

    @Transactional
    public String deleteProduct(Long id) {
        if (!productsRepository.existsById(id)) {
            throw new RuntimeException("Product with id " + id + " not found.");
        }
        productsRepository.deleteById(id);
        return "Product with id " + id + " deleted successfully.";
    }

}
