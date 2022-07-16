package com.android254.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        engine {
            connectTimeout = 10_000
        }

        install(ContentNegotiation) {
//            gson()
        }
    }
}