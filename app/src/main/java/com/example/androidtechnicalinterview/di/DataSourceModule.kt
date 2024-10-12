package com.example.androidtechnicalinterview.di

import com.example.androidtechnicalinterview.data.dataSource.network.remoteDataSource.RemoteSource
import com.example.androidtechnicalinterview.data.dataSource.network.remoteDataSource.RemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindRemoteSourceImpl(remoteImpl: RemoteSourceImpl): RemoteSource

}