package com.possenti.smart.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException(override val message: String? = "user not found.", e: Throwable? = null) : RuntimeException(message, e)