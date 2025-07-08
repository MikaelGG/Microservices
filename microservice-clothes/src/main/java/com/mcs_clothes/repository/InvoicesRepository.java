package com.mcs_clothes.repository;

import com.mcs_clothes.model.InvoicesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<InvoicesModel, Long> {
}
