package com.possenti.smart.security

import com.possenti.smart.services.UserService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
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
                return User(user.email,
                        user.password,
                        true,
                        true,
                        true,
                        true,
                        mutableListOf<GrantedAuthority>(SimpleGrantedAuthority(user.perfil.toString())))
//                return MyUserPrincipal(user)
            }
        }
        throw UsernameNotFoundException(username)
    }

}