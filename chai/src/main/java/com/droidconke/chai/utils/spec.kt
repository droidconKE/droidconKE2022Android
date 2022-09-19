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