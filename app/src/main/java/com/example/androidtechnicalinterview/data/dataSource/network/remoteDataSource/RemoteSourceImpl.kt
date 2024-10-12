package com.example.androidtechnicalinterview.data.dataSource.network.remoteDataSource

import com.example.androidtechnicalinterview.data.dataSource.network.ApiService
import com.example.androidtechnicalinterview.data.dto.posts.PostsDTO
import com.example.androidtechnicalinterview.data.dto.users.UsersDTO
import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult
import com.example.androidtechnicalinterview.utils.ext.safeNetworkCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(private val apiService: ApiService) :
    RemoteSource {

    override suspend fun getUsers(): NetworkResult<UsersDTO> {
        return withContext(Dispatchers.IO) {
            safeNetworkCall {
                val users = apiService.getUsers()
                NetworkResult.Success(users, "Data Founded")
            }
        }
    }

    override suspend fun getPosts(): NetworkResult<PostsDTO> {
        return withContext(Dispatchers.IO) {
            safeNetworkCall {
                val posts = apiService.getPosts()
                NetworkResult.Success(posts, "Data Founded")
            }
        }
    }


}