package com.example.androidtechnicalinterview.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult
import com.example.androidtechnicalinterview.domain.usecase.post.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postUseCase: PostUseCase): ViewModel() {
    private val _uiState = MutableLiveData<MainUiState>()
    val uiState: LiveData<MainUiState> = _uiState

    init {

    }

    fun getPosts() {
        _uiState.postValue(MainUiState.Loading)

        viewModelScope.launch(Dispatchers.Main) {
            postUseCase().let { response ->
                when(response) {
                    is NetworkResult.Failure -> {
                        _uiState.postValue(MainUiState.Error(response.message!!))
                    }

                    is NetworkResult.Success -> {
                        _uiState.postValue(MainUiState.PostSuccess(response.data!!))
                    }
                }
            }
        }
    }


}