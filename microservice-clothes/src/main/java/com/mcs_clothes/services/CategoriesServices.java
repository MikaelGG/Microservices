package com.mcs_clothes.services;

import com.mcs_clothes.model.CategoriesModel;
import com.mcs_clothes.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriesServices {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Transactional
    public CategoriesModel saveCategory(CategoriesModel categoriesModel) {
        if (categoriesRepository.existsByName(categoriesModel.getName())) {
            throw new RuntimeException("Category with name " + categoriesModel.getName() + " already exists.");
        }
        return categoriesRepository.save(categoriesModel);
    }

    @Transactional(readOnly = true)
    public List<CategoriesModel> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CategoriesModel getCategoryById(Long id) {
        return categoriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id " + id + " not found."));
    }

    @Transactional
    public CategoriesModel updateCategory(Long id, CategoriesModel categoriesModel) {
        CategoriesModel categoryModel = categoriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id " + id + " not found."));
        if (!categoryModel.getName().equals(categoriesModel.getName()) && categoriesRepository.existsByName(categoriesModel.getName())) {
            throw new RuntimeException("Category with name " + categoriesModel.getName() + " already exists.");
        }
        categoryModel.setName(categoriesModel.getName());
        return categoriesRepository.save(categoryModel);
    }

    @Transactional
    public String deleteCategory(Long id) {
        if (!categoriesRepository.existsById(id)) {
            throw new RuntimeException("Category with id " + id + " not found.");
        }
        categoriesRepository.deleteById(id);
        return "Category with id " + id + " deleted successfully.";
    }

}
