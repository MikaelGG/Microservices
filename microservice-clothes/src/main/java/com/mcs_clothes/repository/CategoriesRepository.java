package com.mcs_clothes.repository;

import com.mcs_clothes.model.CategoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesModel, Long> {
    boolean existsByName(String name);

}
