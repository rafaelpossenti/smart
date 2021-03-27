package com.possenti.smart.controllers.post

import com.possenti.smart.client.PostClient
import com.possenti.smart.dtos.post.PostDto
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/api/smart/posts")
class PostController(val postClient: PostClient) {

    @PostMapping
    fun save(@Valid @RequestBody post: PostDto)  {
        post.userId = this.getUserName()
        postClient.save(post)
    }

    private fun getUserName() : String {
        val principal = SecurityContextHolder.getContext().authentication.principal
        return if (principal is UserDetails) {
            principal.username
        } else {
            principal.toString()
        }
    }

}