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
package com.droidconke.chai.icons

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.droidconke.chai.R

/**
 * An abstraction that defines the icons to be used instead of
 * accessing icon resources directly
 * @param drawableId icon drawable resource id
 */
@Immutable
@JvmInline
value class ChaiIcon private constructor(@DrawableRes val drawableId:Int){
    companion object{
       @Stable
        val About = ChaiIcon(drawableId = R.drawable.about_icon)
        @Stable
        val FeedIcon = ChaiIcon(drawableId = R.drawable.feed_icon)
        @Stable
        val HomeIcon = ChaiIcon(drawableId = R.drawable.home_icon)
        @Stable
        val SessionsIcon = ChaiIcon(drawableId = R.drawable.sessions_icon)
        @Stable
        val BackArrow = ChaiIcon(drawableId = R.drawable.ic_back_arrow)
        @Stable
        val GoogleIcon = ChaiIcon(drawableId = R.drawable.ic_google_logo_icon)
    }
}