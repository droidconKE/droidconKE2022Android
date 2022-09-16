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