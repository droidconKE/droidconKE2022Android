package com.android254.presentation.models

import androidx.annotation.DrawableRes
import com.android254.presentation.R

data class OrganizingTeamMember(
    val name: String = "",
    val desc: String = "",
    @DrawableRes val image: Int,
)

var organizingTeamMembers = listOf<OrganizingTeamMember>(
    OrganizingTeamMember(
        name = "Frank Tamre",
        desc = "Main Man",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Marvin Collins",
        desc = "Main man 2",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Jackline",
        desc = "Main Chick",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "John Mwendwa",
        desc = "A Hobbit",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Lincoln",
        desc = "A Stark",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Manuel Geek",
        desc = "FIFA Looser",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Kendy or Cendy",
        desc = "You guy my guy",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Harun Wangereka",
        desc = "The Other Guy",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Philomena",
        desc = "Main chick 2",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Michael",
        desc = "The Guy",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Danvick",
        desc = "The Dev",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Annie",
        desc = "Looser Team",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Chepsi",
        desc = "You guy my guy",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Monique",
        desc = "Strange school",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Cindy",
        desc = "The Girl",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Josh",
        desc = "The Guy",
        image = R.drawable.about_droidcon
    ),
    OrganizingTeamMember(
        name = "Theo",
        desc = "Strange school",
        image = R.drawable.about_droidcon
    ),
)