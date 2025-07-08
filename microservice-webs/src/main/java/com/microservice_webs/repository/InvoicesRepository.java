package com.microservice_webs.repository;

import com.microservice_webs.model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long> {
}
