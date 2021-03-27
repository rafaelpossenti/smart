package com.possenti.smart.client

import com.possenti.smart.dtos.post.PostDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@FeignClient("post")
interface PostClient {

    @PostMapping("/api/post/posts")
    fun save(@Valid @RequestBody postDto: PostDto): ResponseEntity<String>

    @RequestMapping("/api/post/posts")
    fun listarPorId(): String
}