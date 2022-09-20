package com.android254.presentation.speakers

import androidx.lifecycle.ViewModel
import com.android254.presentation.models.Speaker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpeakerViewMode @Inject constructor() : ViewModel(){

    val speakersList = listOf(
        Speaker(
            imageUrl = "https://sessionize.com/image/09c1-400o400o2-cf-9587-423b-bd2e-415e6757286c.b33d8d6e-1f94-4765-a797-255efc34390d.jpg",
            name = "Harun Wangereka",
            bio = "Kenya Partner Lead at droidcon Berlin | Android | Kotlin | Flutter | C++"
        ),
        Speaker(
            imageUrl = "https://media-exp1.licdn.com/dms/image/C4D03AQGn58utIO-x3w/profile-displayphoto-shrink_200_200/0/1637478114039?e=2147483647&v=beta&t=3kIon0YJQNHZojD3Dt5HVODJqHsKdf2YKP1SfWeROnI",
            name = "Frank Tamre",
            bio = "Kenya Partner Lead at droidcon Berlin | Android | Kotlin | Flutter | C++"
        )
    )
}