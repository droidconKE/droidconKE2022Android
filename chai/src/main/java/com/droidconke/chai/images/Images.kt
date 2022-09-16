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
package com.droidconke.chai.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.droidconke.chai.atoms.ChaiColor
import com.droidconke.chai.icons.ChaiIcon
import com.droidconke.chai.modifier.chaiClickable

/**
 * An image component that uses icons
 *
 * @param icon to be used which is a drawable
 * @param tint tint color to be applied to the icon
 * @param contentDescription content description of the icon
 * @param rippleEnabled whether ripple animation is enabled
 * @param onClick on click listener attached to this image component
 */
@Composable
@NonRestartableComposable
fun ChaiImage(modifier: Modifier=Modifier,
              icon:ChaiIcon?,
              tint:ChaiColor?=null,
              contentDescription:String?=null,
              rippleEnabled:Boolean=true,onClick:(()->Unit)?=null){
    if (icon==null) return
    Image(modifier = modifier.chaiClickable(rippleEnabled=rippleEnabled,
        onClick = onClick),
        painter =painterResource(id = icon.drawableId),
        contentDescription =contentDescription,
    colorFilter = tint.toColorFilter())
}

private fun ChaiColor?.toColorFilter() = this?.run { ColorFilter.tint(color=value) }