package com.microservice_webs.clients;

import feign.Client;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ClientFeignConfig {

    @Bean
    public Request.Options options() {
        return new Request.Options(
                30, TimeUnit.SECONDS, // connect timeout
                30, TimeUnit.SECONDS, // read timeout
                true
        );
    }

    @Bean
    public Client client() {
        return new Client.Default(null, null);
    }
}
