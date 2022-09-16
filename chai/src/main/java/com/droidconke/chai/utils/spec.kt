package com.droidconke.chai.utils

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Stable

/**
 * Default duration time to be used in ChaiDesign system
 */
const val ChaiDefaultAnimationMillis = 250
/**
 * Basic/default animation spec to be used by ChaiDesign system
 * @return tween animation spec
 */
@Stable
internal fun <T> chaiAnimationSpec() = tween<T>(
    durationMillis = ChaiDefaultAnimationMillis,
    easing = FastOutSlowInEasing
)