package com.possenti.smart.services

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {

    //INSERT
    @Test
    fun `Insert new valid user must return a valid user `() {
    }

    @Test
    fun `Insert new user with an empty name must return an error`() {
    }

    @Test
    fun `Insert new user with a name lesser than 3 characters must return an error`() {
    }

    @Test
    fun `Insert new user with a name greater than 30 characters must return an error`() {
    }

    @Test
    fun `Insert new user with an empty email must return an error`() {
    }

    @Test
    fun `Insert new user with a email lesser than 5 characters must return an error`() {
    }

    @Test
    fun `Insert new user with a email greater than 200 characters must return an error`() {
    }

    @Test
    fun `Insert new user with an invalid email must return an error`() {
    }

    @Test
    fun `Insert new user with an empty password must return an error`() {
    }

    @Test
    fun `Insert new user with a password lesser than 5 characters must return an error`() {
    }

    @Test
    fun `Insert new user with a password greater than 30 characters must return an error`() {
    }

    //UPDATE
    @Test
    fun `update with a not found user must return an error `() {
    }

    @Test
    fun `update an user with an empty password must return an error`() {
    }

    @Test
    fun `update an user with a password lesser than 5 characters must return an error`() {
    }

    @Test
    fun `update an user with a password greater than 30 characters must return an error`() {
    }

    @Test
    fun `update an user with a valid password must change the password `() {
    }

    @Test
    fun `update an user with an empty name must return an error`() {
    }

    @Test
    fun `update an user with a name lesser than 3 characters must return an error`() {
    }

    @Test
    fun `update an user with a name greater than 30 characters must return an error`() {
    }

    @Test
    fun `update an user with a valid name must change the name `() {
    }

    //DELETE

    //findByEmail

    //findAll

    //saveImage
}