package com.possenti.smart.client

import com.possenti.smart.dtos.post.PostDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@FeignClient("post")
interface PostClient {

    @PostMapping("/api/post/posts")
    fun save(@Valid @RequestBody postDto: PostDto): ResponseEntity<String>

    @GetMapping("/api/post/posts/{user_id}")
    fun get(@RequestParam(value = "pag", defaultValue = "0") pag: Int,
            @RequestParam(value = "ord", defaultValue = "id") ord: String,
            @RequestParam(value = "dir", defaultValue = "DESC") dir: String,
            @PathVariable("user_id") userId: String):
            ResponseEntity<List<PostDto>>
}