package com.mcs_clothes.clients;

import com.mcs_clothes.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-client", path = "/api/clients")
public interface ClientFeignClothes {

    @GetMapping
    List<ClientDTO> getClients();

    @GetMapping(value = "/{id}")
    ClientDTO getClientById(@PathVariable("id") Long id);

}
