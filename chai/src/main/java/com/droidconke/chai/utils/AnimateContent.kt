package com.droidconke.chai.utils

import androidx.compose.animation.*
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize

/**
 * Function which animates content change whenever state of a composable state
 *@param targetState composable's state to watch for changes
 *@param content content to be shown by AnimatedContent container
 *@param animationSpec animation spec to be used by default chaiAnimationSpec is used
 */
@Suppress("UNCHECKED_CAST")
@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun <T> AnimateContentChange(
    modifier: Modifier = Modifier,
    targetState: T,
    animationSpec: AnimationSpec<Any> = chaiAnimationSpec(),
    content: @Composable AnimatedVisibilityScope.(animatedTargetState: T) -> Unit
) {
    AnimatedContent(
        targetState = targetState, modifier = modifier, content = content,
        transitionSpec = {
            fadeIn(
                animationSpec = animationSpec as FiniteAnimationSpec<Float>,
            ) with fadeOut(
                animationSpec = animationSpec as FiniteAnimationSpec<Float>,
            ) using SizeTransform(
                clip = false,
                sizeAnimationSpec = { _, _ ->
                    animationSpec as FiniteAnimationSpec<IntSize>
                },
            )
        }
    )
}