package com.possenti.smart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
//TODO: use Resilience4j https://www.infoq.com/br/articles/spring-cloud-hystrix/
class SmartApplication

fun main(args: Array<String>) {
	runApplication<SmartApplication>(*args)
}
