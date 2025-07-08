package com.microservice_webs.service;

import com.microservice_webs.dto.WebPagesDTO;
import com.microservice_webs.model.Developers;
import com.microservice_webs.model.WebDevelopers;
import com.microservice_webs.model.WebPages;
import com.microservice_webs.repository.DevelopersRepository;
import com.microservice_webs.repository.WebDevelopersRepository;
import com.microservice_webs.repository.WebPagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WebPagesService {

    @Autowired
    WebPagesRepository webPagesRepository;
    @Autowired
    DevelopersRepository developersRepository;
    @Autowired
    WebDevelopersRepository webDevelopersRepository;

    @Transactional
    public WebPagesDTO saveWebPage(WebPagesDTO webPagesDTO) {
        WebPages webPages = new WebPages();
        webPages.setName(webPagesDTO.getName());
        webPages.setDescription(webPagesDTO.getDescription());
        webPages.setPrice(webPagesDTO.getPrice());
        webPagesRepository.save(webPages);
        for (WebPagesDTO.Devs dev : webPagesDTO.getDevsList()) {
            Developers developers = developersRepository.findById(dev.getId()).orElseThrow(() -> new RuntimeException("Developer not found with id: " + dev.getId()));
            WebDevelopers webDevelopers = new WebDevelopers();
            webDevelopers.setIdWeb(webPages);
            webDevelopers.setIdDeveloper(developers);
            webDevelopersRepository.save(webDevelopers);
        }
        return webPagesDTO;
    }

}
