package com.microservice_webs.controller;

import com.microservice_webs.dto.WebPagesDTO;
import com.microservice_webs.model.WebPages;
import com.microservice_webs.service.WebPagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webpages")
public class WebPagesRESTController {

    @Autowired
    WebPagesService webPagesService;

    @PostMapping
    public ResponseEntity<WebPagesDTO> createWebPage(@RequestBody WebPagesDTO body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(webPagesService.saveWebPage(body));
    }

}
