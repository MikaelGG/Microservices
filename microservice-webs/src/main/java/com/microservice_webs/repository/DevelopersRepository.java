package com.microservice_webs.repository;

import com.microservice_webs.model.Developers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopersRepository extends JpaRepository<Developers, Long> {
}
