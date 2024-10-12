package com.example.androidtechnicalinterview.domain.usecase.post

import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult
import com.example.androidtechnicalinterview.domain.model.post.Post

interface PostUseCase {

    suspend operator fun invoke(): NetworkResult<MutableList<Post>>

}