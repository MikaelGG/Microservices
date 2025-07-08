package com.microservice_webs.repository;

import com.microservice_webs.model.WebPages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebPagesRepository extends JpaRepository<WebPages, Long> {
}
