package com.microservice_webs.clients;

import com.microservice_webs.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-client", path = "/api/clients")
public interface ClientFeignClient {

    @GetMapping
    List<ClientDTO> getClients();

    @GetMapping(value = "/{id}")
    ClientDTO getClientById(@PathVariable("id") Long id);

}
