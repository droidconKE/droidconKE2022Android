package com.android254.data.network

import com.android254.data.network.util.TokenProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class MockTokenProvider : TokenProvider {
    override suspend fun fetch(): Flow<String?> = emptyFlow()
    override suspend fun update(accessToken: String) {}
}