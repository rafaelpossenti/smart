package com.possenti.smart.security

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequestModel(
        @JsonProperty("email")
        val email: String,

        @JsonProperty("password")
        val password: String
)