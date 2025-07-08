package com.microservice_webs.repository;

import com.microservice_webs.model.WebDevelopers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebDevelopersRepository extends JpaRepository<WebDevelopers, Long> {
}
