package com.example.androidtechnicalinterview.domain.repository

import com.example.androidtechnicalinterview.data.dto.users.UsersDTO
import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult

interface UsersRepository {
    suspend fun getUsers(): NetworkResult<UsersDTO>
}