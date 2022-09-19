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