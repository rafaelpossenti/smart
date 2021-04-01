package com.possenti.smart.security

import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.core.env.Environment
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class AuthenticationFilter(
        val myUserDetailsService: MyUserDetailsService,
        val env: Environment,
        val authentication: AuthenticationManager
) : UsernamePasswordAuthenticationFilter(authentication) {

    override fun attemptAuthentication(req: HttpServletRequest,
                                       res: HttpServletResponse): Authentication {

            val creds: LoginRequestModel = ObjectMapper().readValue(req.inputStream, LoginRequestModel::class.java)
            return authentication.authenticate(
                    UsernamePasswordAuthenticationToken(
                            creds.email,
                            creds.password,
                            ArrayList())
            )

    }

    override fun successfulAuthentication(req: HttpServletRequest?,
                                          res: HttpServletResponse,
                                          chain: FilterChain?,
                                          auth: Authentication) {
        val userName: String = (auth.principal as User).username

        val userDetails = myUserDetailsService.loadUserByUsername(userName)

        val token: String = Jwts.builder()
                .setSubject(userDetails.username)
                .setExpiration(Date(System.currentTimeMillis() + env.getProperty("token.expiration_time")!!.toLong()))
                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
                .compact()
        res.addHeader("token", token)
        res.addHeader("userId", userDetails.username)
    }
}