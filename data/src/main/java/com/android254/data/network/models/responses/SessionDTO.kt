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
package com.android254.data.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionDTO(
    @SerialName("description")
    val description: String? = "",
    @SerialName("is_keynote")
    val isKeynote: Boolean? = false,
    @SerialName("session_format")
    val sessionFormat: String? = "",
    @SerialName("session_image")
    val sessionImage: String? = "",
    @SerialName("session_level")
    val sessionLevel: String? = "",
    @SerialName("slug")
    val slug: String? = "",
    @SerialName("speakers")
    val speakers: List<Speaker?>? = listOf(),
    @SerialName("title")
    val title: String? = ""
) {
    @Serializable
    data class Speaker(
        @SerialName("avatar")
        val avatar: String? = "",
        @SerialName("biography")
        val biography: String? = "",
        @SerialName("blog")
        val blog: String? = "",
        @SerialName("company_website")
        val companyWebsite: String? = "",
        @SerialName("facebook")
        val facebook: String? = "",
        @SerialName("instagram")
        val instagram: String? = "",
        @SerialName("linkedin")
        val linkedin: String? = "",
        @SerialName("name")
        val name: String? = "",
        @SerialName("tagline")
        val tagline: String? = "",
        @SerialName("twitter")
        val twitter: String? = ""
    )
}