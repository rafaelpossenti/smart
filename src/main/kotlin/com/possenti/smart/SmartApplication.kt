package com.possenti.smart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartApplication

fun main(args: Array<String>) {
	runApplication<SmartApplication>(*args)
}
