package com.mcs_clothes.repository;

import com.mcs_clothes.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Long> {
    boolean existsByName(String name);
}