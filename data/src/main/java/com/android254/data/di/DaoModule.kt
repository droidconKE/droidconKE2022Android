package com.android254.data.di

import com.android254.data.Database
import com.android254.data.dao.SessionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesAuthorDao(
        database: Database,
    ): SessionDao = database.sessionDao()
}
