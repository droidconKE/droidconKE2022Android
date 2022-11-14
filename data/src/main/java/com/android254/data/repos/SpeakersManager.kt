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

import com.android254.data.db.Database
import com.android254.data.network.apis.SpeakersApi
import com.android254.domain.models.DataResult
import com.android254.domain.models.ResourceResult
import com.android254.domain.models.Speaker
import com.android254.domain.repos.SpeakersRepo
import javax.inject.Inject

class SpeakersManager @Inject constructor(
    db: Database,
    private val api: SpeakersApi
) : SpeakersRepo {
    val speakerDao = db.speakerDao()

    override suspend fun fetchSpeakers(): ResourceResult<List<Speaker>> {
        println("PPPPPPPPPPPPPPPPPPPPPP")
        return when (val result = api.fetchSpeakers()) {
            is DataResult.Success -> {
                println("tttttttttttttttttttttttt")
                val data = result.data.data
                if (data.isEmpty()) {
                    ResourceResult.Empty()
                }
                println(data)
                ResourceResult.Success(emptyList())
            }
            is DataResult.Error -> {
                ResourceResult.Error(
                    result.message,
                    networkError = result.message.contains("network", ignoreCase = true)
                )
            }
            else -> {
                println("mmmmmmmmmmmmmmmmmmm")
                ResourceResult.Success(emptyList())
            }
        }
    }
}