package com.possenti.smart.security

import com.possenti.smart.documents.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class MyUserPrincipal(val user: User) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities: MutableCollection<GrantedAuthority> = mutableListOf()
        authorities.add(SimpleGrantedAuthority(user.perfil.toString()))
        return authorities
    }

    override fun isEnabled() = true

    override fun getUsername() = user.email

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = user.password!!

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

}