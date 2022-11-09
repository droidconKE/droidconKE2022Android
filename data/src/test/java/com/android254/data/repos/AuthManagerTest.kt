/*
 * Copyright 2022 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.data.repos

import com.android254.data.network.apis.AuthApi
import com.android254.data.network.models.responses.AccessToken
import com.android254.data.network.models.responses.UserDetails
import com.android254.data.network.util.NetworkError
import com.android254.data.network.util.TokenProvider
import com.android254.domain.models.DataResult
import com.android254.domain.models.Success
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AuthManagerTest {
    private val fakeUserDetails = UserDetails(
        name = "Test",
        email = "test@gmail.com",
        gender = null,
        avatar = "http://test.com"
    )

    @MockK
    private lateinit var authApi: AuthApi

    @MockK
    private lateinit var tokenProvider: TokenProvider

    private lateinit var authManager: AuthManager
    private lateinit var exception: Exception
    private lateinit var networkError: NetworkError

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        authManager = AuthManager(authApi, tokenProvider)
        networkError = NetworkError()
        exception = Exception()
    }

    @Test
    fun `test getAndSaveApiToken successfully`() = runTest {
        // Given
        coEvery { authApi.googleLogin(any()) } returns AccessToken(
            "test",
            user = fakeUserDetails
        )
        coEvery { tokenProvider.update(any()) } just Runs

        // When
        val result = authManager.getAndSaveApiToken("test")

        //Then
        coVerify { tokenProvider.update("test") }

        // And
        Truth.assertThat(result).isEqualTo(DataResult.Success(Success))
    }

    @Test
    fun `test getAndSaveApiToken failure - network error`() = runTest {
        // Given
        val exc = NetworkError()
        coEvery { authApi.googleLogin(any()) } throws networkError

        // When
        val result = authManager.getAndSaveApiToken("test")

        // Then
        Truth.assertThat(result).isEqualTo(DataResult.Error("Login failed", true, networkError))
    }

    @Test
    fun `test getAndSaveApiToken failure - other error`() = runTest {
        // Given
        coEvery { authApi.googleLogin(any()) } throws exception

        // When
        val result = authManager.getAndSaveApiToken("test")

        // Then
        Truth.assertThat(result).isEqualTo(DataResult.Error("Login failed", exc = exception))
    }
}