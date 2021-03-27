package com.possenti.smart.security

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class configRestTemplate {

    @Bean
    @LoadBalanced
    fun getRestTemplate() = RestTemplate()
}