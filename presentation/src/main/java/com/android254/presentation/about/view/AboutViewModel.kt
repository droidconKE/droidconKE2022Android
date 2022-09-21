package com.android254.presentation.about.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android254.presentation.R
import com.android254.presentation.models.OrganizingTeamMember
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor() : ViewModel() {

    private val sampleImageUrl: String = "https://media-exp1.licdn.com/dms/image/C4D03AQGn58utIO-x3w/profile-displayphoto-shrink_200_200/0/1637478114039?e=2147483647&v=beta&t=3kIon0YJQNHZojD3Dt5HVODJqHsKdf2YKP1SfWeROnI"

    val organizingTeamMembers = mutableStateOf(
        listOf(
            OrganizingTeamMember(
                name = "Frank Tamre",
                desc = "Main Man",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Marvin Collins",
                desc = "Main man 2",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Jackline",
                desc = "Main Chick",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "John Mwendwa",
                desc = "A Hobbit",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Lincoln",
                desc = "A Stark",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Manuel Geek",
                desc = "FIFA Looser",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Kendy or Cendy",
                desc = "You guy my guy",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Harun Wangereka",
                desc = "The Other Guy",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Philomena",
                desc = "Main chick 2",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Michael",
                desc = "The Guy",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Danvick",
                desc = "The Dev",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Annie",
                desc = "Looser Team",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Chepsi",
                desc = "You guy my guy",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Monique",
                desc = "Strange school",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Cindy",
                desc = "The Girl",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Josh",
                desc = "The Guy",
                image = sampleImageUrl
            ),
            OrganizingTeamMember(
                name = "Theo",
                desc = "Strange school",
                image = sampleImageUrl
            ),
        )
    )

    var stakeHolderLogos = mutableStateOf(
        listOf(
            R.drawable.ic_android254,
            R.drawable.kotlin_kenya_logo,
            R.drawable.k_logo,
            R.drawable.apps_lab_logo,
            R.drawable.early_camp_logo,
            R.drawable.ic_tiskos_logo,
        )
    )
}