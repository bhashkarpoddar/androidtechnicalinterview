package com.example.androidtechnicalinterview.di

import com.example.androidtechnicalinterview.domain.repository.PostsRepository
import com.example.androidtechnicalinterview.domain.repository.UsersRepository
import com.example.androidtechnicalinterview.domain.usecase.post.PostUseCase
import com.example.androidtechnicalinterview.domain.usecase.post.PostUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun providePostUpUseCase(usersRepository: UsersRepository, postsRepository: PostsRepository): PostUseCase =
        PostUseCaseImpl(usersRepository, postsRepository)

}