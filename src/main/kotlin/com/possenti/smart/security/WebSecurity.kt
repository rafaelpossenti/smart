package com.possenti.smart.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurity(
        val myUserDetailsService: MyUserDetailsService,
        val environment: Environment
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }


    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests()
                .antMatchers("/users/login").permitAll()
//                .anyRequest().authenticated()
                .and()
                .addFilter(getAuthenticationFilter())
        http.headers().frameOptions().disable();
    }

    private fun getAuthenticationFilter(): AuthenticationFilter? {
        val authenticationFilter = AuthenticationFilter(myUserDetailsService, environment, authenticationManager())
        authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"))
        return authenticationFilter
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(myUserDetailsService)
        authProvider.setPasswordEncoder(encoder())
        return authProvider
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()

}