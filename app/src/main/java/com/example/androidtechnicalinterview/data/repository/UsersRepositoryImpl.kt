package com.example.androidtechnicalinterview.data.repository

import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult
import com.example.androidtechnicalinterview.domain.repository.UsersRepository
import com.example.androidtechnicalinterview.data.dataSource.network.remoteDataSource.RemoteSource
import com.example.androidtechnicalinterview.data.dto.users.UsersDTO
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val remoteSource: RemoteSource):
    UsersRepository {

    override suspend fun getUsers(): NetworkResult<UsersDTO> = remoteSource.getUsers()

}