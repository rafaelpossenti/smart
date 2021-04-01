//package com.possenti.smart.controllers.post
//
//import com.possenti.smart.client.PostClient
//import com.possenti.smart.dtos.post.PostDto
//import com.possenti.smart.services.post.PostService
//import org.springframework.http.ResponseEntity
//import org.springframework.security.core.context.SecurityContextHolder
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.web.bind.annotation.*
//import javax.validation.Valid
//
//
//@RestController
//@RequestMapping("/api/smart/posts")
//class PostController(val postService: PostService) {
//
//    @PostMapping
//    fun save(@Valid @RequestBody post: PostDto)  {
//        postService.save(post)
//    }
//
//    @GetMapping
//    fun findByUserId(@RequestParam(value = "pag", defaultValue = "0") pag: Int,
//                     @RequestParam(value = "ord", defaultValue = "id") ord: String,
//                     @RequestParam(value = "dir", defaultValue = "DESC") dir: String) : ResponseEntity<List<PostDto>> {
//        return postService.findByUserId(pag, ord, dir)
//    }
//
//
//
//}