package com.possenti.smart.controllers.post

import com.possenti.smart.client.PostClient
import com.possenti.smart.dtos.post.PostDto
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/smart/posts")
class PostController(val postClient: PostClient) {

    @PostMapping
    fun save(@Valid @RequestBody post: PostDto)  {
        post.userId = this.getUserName()
        postClient.save(post)
    }

    @GetMapping
    fun findByUserId(@RequestParam(value = "pag", defaultValue = "0") pag: Int,
                     @RequestParam(value = "ord", defaultValue = "id") ord: String,
                     @RequestParam(value = "dir", defaultValue = "DESC") dir: String) : ResponseEntity<List<PostDto>> {
        val userId = this.getUserName()
        return postClient.get(pag, ord, dir, userId)
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