package com.example.androidtechnicalinterview.di

import com.example.androidtechnicalinterview.domain.repository.PostsRepository
import com.example.androidtechnicalinterview.domain.repository.UsersRepository
import com.example.androidtechnicalinterview.data.repository.PostsRepositoryImpl
import com.example.androidtechnicalinterview.data.repository.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindUserRepositoryImpl(usersRepositoryImpl: UsersRepositoryImpl): UsersRepository

    @Binds
    @Singleton
    fun bindPostRepositoryImpl(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository


}