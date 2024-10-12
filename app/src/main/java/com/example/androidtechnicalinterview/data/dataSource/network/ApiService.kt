package com.example.androidtechnicalinterview.data.dataSource.network

import com.example.androidtechnicalinterview.data.dto.posts.PostsDTO
import com.example.androidtechnicalinterview.data.dto.users.UsersDTO
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): UsersDTO

    @GET("posts")
    suspend fun getPosts(): PostsDTO


}