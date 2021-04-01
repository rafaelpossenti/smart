//package com.possenti.smart.services.post
//
//import com.possenti.smart.client.PostClient
//import com.possenti.smart.dtos.post.PostDto
//import org.springframework.http.ResponseEntity
//import org.springframework.security.core.context.SecurityContextHolder
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.stereotype.Service
//
//@Service
//class PostService(val postClient: PostClient) {
//
//    fun save(post: PostDto)  {
//        post.userId = this.getUserName()
//        postClient.save(post)
//    }
//
//    fun findByUserId(pag: Int, ord: String, dir: String) : ResponseEntity<List<PostDto>> {
//        val userId = this.getUserName()
//        return postClient.get(pag, ord, dir, userId)
//    }
//
//    private fun getUserName() : String {
//        val principal = SecurityContextHolder.getContext().authentication.principal
//        return if (principal is UserDetails) {
//            principal.username
//        } else {
//            principal.toString()
//        }
//    }
//}