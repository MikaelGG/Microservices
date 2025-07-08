package com.microservice_webs.service;

import com.microservice_webs.model.Developers;
import com.microservice_webs.repository.DevelopersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DevelopersService {

    @Autowired
    DevelopersRepository developersRepository;

    @Transactional
    public Developers saveDeveloper(Developers developer) {
        return developersRepository.save(developer);
    }

    @Transactional(readOnly = true)
    public List<Developers> getAllDevelopers() {
        return developersRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Developers getDeveloperById(Long id) {
        return developersRepository.findById(id).orElseThrow(() -> new RuntimeException("Developer not found with id: " + id));
    }

    @Transactional
    public Developers updateDeveloper(Long id, Developers developer) {
        Developers developerFound = developersRepository.findById(id).orElseThrow(() -> new RuntimeException("Developer not found with id: " + id));
        developerFound.setName(developer.getName());
        developerFound.setLastName(developer.getLastName());
        developerFound.setAge(developer.getAge());
        developerFound.setShortDescription(developer.getShortDescription());
        return developersRepository.save(developerFound);
    }

    @Transactional
    public String deleteDeveloper(Long id) {
        Developers developerFound = developersRepository.findById(id).orElseThrow(() -> new RuntimeException("Developer not found with id: " + id));
        developersRepository.delete(developerFound);
        return "Developer deleted successfully with id: " + id;
    }

}
