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
package com.android254.domain.usecases

import com.android254.domain.models.DataResult
import com.android254.domain.models.SpeakerDomainModel
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class GetSpeakersUseCaseTest {
    @Test
    fun `returns speakers data as received from the speaker repository`() = runTest {
        val expectedSpeakers = listOf(
            SpeakerDomainModel(
                id = "1",
                name = "John Doe",
                shortBio = "Kotlin GDE",
                bio = "I love contributing to OS",
                avatar = "https://example.com",
                session = "session_id_1",
                twitter = null
            )
        )
        val getSpeakers = GetSpeakersUseCase(
            MockSpeakerRepository(speakers = expectedSpeakers)
        )

        assertThat(getSpeakers(), `is`(DataResult.Success(expectedSpeakers)))
    }
}