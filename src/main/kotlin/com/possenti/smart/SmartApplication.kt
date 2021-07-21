package com.possenti.smart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.web.config.EnableSpringDataWebSupport

@SpringBootApplication
@EnableFeignClients
@EnableSpringDataWebSupport
class SmartApplication

fun main(args: Array<String>) {
	runApplication<SmartApplication>(*args)
}
