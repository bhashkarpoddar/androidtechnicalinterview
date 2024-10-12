package com.example.androidtechnicalinterview.data.dataSource.network.remoteDataSource

import com.example.androidtechnicalinterview.data.dto.posts.PostsDTO
import com.example.androidtechnicalinterview.data.dto.users.UsersDTO
import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult


interface RemoteSource {

    suspend fun getUsers(): NetworkResult<UsersDTO>

    suspend fun getPosts(): NetworkResult<PostsDTO>
}