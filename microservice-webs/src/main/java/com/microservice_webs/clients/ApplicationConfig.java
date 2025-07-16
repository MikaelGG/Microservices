package com.microservice_webs.clients;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.loadbalancer.config.LoadBalancerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.loadbalancer.LoadBalancerEurekaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.microservice_webs.clients")
@EnableAutoConfiguration(exclude = {
        LoadBalancerAutoConfiguration.class,
        LoadBalancerEurekaAutoConfiguration.class
})
public class ApplicationConfig {

}
