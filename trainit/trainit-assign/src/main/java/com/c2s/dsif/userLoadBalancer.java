package com.c2s.dsif;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient("collab")
public class userLoadBalancer {

    @LoadBalanced
    @Bean
    Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
