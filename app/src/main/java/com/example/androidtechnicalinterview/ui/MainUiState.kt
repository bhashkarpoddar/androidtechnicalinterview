package com.example.androidtechnicalinterview.ui

import com.example.androidtechnicalinterview.domain.model.post.Post

sealed class MainUiState {
    object Loading: MainUiState()
    object Empty: MainUiState()
    object Reload: MainUiState()
    object DefaultState: MainUiState()
    data class Error(val errorMessage: String): MainUiState()
    data class PostSuccess(val posts: MutableList<Post>): MainUiState()
}