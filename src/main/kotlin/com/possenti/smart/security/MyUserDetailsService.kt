package com.possenti.smart.security

import com.possenti.smart.services.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(val userService: UserService) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username != null) {
            val user = userService.findByEmail(username)
            if (user != null) {
                return MyUserPrincipal(user)
            }
        }
        throw UsernameNotFoundException(username)
    }

}