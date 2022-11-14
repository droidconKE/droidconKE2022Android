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
package com.android254.presentation.speakers

import androidx.lifecycle.ViewModel
import com.android254.domain.models.ResourceResult
import com.android254.domain.repos.SpeakersRepo
import com.android254.presentation.models.SpeakerUI
import com.android254.presentation.models.speakersDummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SpeakersViewModel @Inject constructor(
    private val speakersRepo: SpeakersRepo
) : ViewModel() {

    val isLoading = MutableStateFlow(false)
    val message = MutableSharedFlow<String>()

    suspend fun getSpeakers(): List<SpeakerUI> {
        isLoading.value = true
        when (val result = speakersRepo.fetchSpeakers()) {
            is ResourceResult.Success -> {
                val list = result.data?.map { }
                println(list)
            }
            is ResourceResult.Error -> {
                println("lllllllllllllllllllllllll")
                println(result.message)
                message.tryEmit(result.message)
            }
            else -> {}
        }
        isLoading.value = false
        return speakersDummyData
    }

    fun getSpeakerByTwitterHandle(twitterHandle: String) = SpeakerUI(
        imageUrl = "https://media-exp1.licdn.com/dms/image/C4D03AQGn58utIO-x3w/profile-displayphoto-shrink_200_200/0/1637478114039?e=2147483647&v=beta&t=3kIon0YJQNHZojD3Dt5HVODJqHsKdf2YKP1SfWeROnI",
        name = "Frank Tamre",
        tagline = "Kenya Partner Lead at droidcon Berlin | Android | Kotlin | Flutter",
        bio = """
                    Worked at Intel, co-Founded Moringa School, 
                    then started @earlycamp to train young children 
                    from 5-16 on how to solve problems with technology. 
                    Started 818interactive to tell African stories 
                    with Games to a global audience. Community wise 
                    I organize #Android & #Kotlin developers every 
                    month for a meetUp to chat about technology. 
                    I Lead a cool team in organizing #droidConKE 
                    the largest android developer focussed event 
                    in Sub Saharan Africa. I train people,mentor them, 
                    build things, am highly experimental, 
                    read a lot and socialize vertically.
        """.trimIndent()
    )
}