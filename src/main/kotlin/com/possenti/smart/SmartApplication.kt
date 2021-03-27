package com.possenti.smart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SmartApplication

fun main(args: Array<String>) {
	runApplication<SmartApplication>(*args)
}
