package com.example.androidtechnicalinterview.data.repository

import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult
import com.example.androidtechnicalinterview.domain.repository.PostsRepository
import com.example.androidtechnicalinterview.data.dataSource.network.remoteDataSource.RemoteSource
import com.example.androidtechnicalinterview.data.dto.posts.PostsDTO
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val remoteSource: RemoteSource):
    PostsRepository {

    override suspend fun getPosts(): NetworkResult<PostsDTO> = remoteSource.getPosts()
}