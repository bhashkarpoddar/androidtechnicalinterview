package com.example.androidtechnicalinterview.domain.repository

import com.example.androidtechnicalinterview.data.dto.posts.PostsDTO
import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult

interface PostsRepository {
    suspend fun getPosts(): NetworkResult<PostsDTO>
}