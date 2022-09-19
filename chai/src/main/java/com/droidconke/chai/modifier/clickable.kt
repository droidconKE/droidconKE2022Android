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
package com.droidconke.chai.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.droidconke.chai.atoms.ChaiColor

/**
 * Modifier that can be used to make components clickable
 * @param onClick the listener to be used when component is clicked
 * @param rippleColor ripple color to be used when component is clicked
 * @param rippleEnabled whether or not ripple animation/effect is enabled
 * by default it is
 * @return clickable modifier
 */
@Stable
internal fun Modifier.chaiClickable(
    rippleEnabled: Boolean = true,
    rippleColor: ChaiColor? = null,
    onClick: (() -> Unit)?
) = when (onClick != null) {
    true -> composed {
        clickable(
            onClick = onClick,
            indication = rememberRipple(
                color = rippleColor?.value ?: ChaiColor.Unspecified.value,
            ).takeIf {
                rippleEnabled
            },
            interactionSource = remember { MutableInteractionSource() }
        )
    }
    else -> this
}