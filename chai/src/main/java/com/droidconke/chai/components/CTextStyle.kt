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
package com.droidconke.chai.components

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.droidconke.chai.R
import com.droidconke.chai.atoms.ChaiColor
import com.droidconke.chai.atoms.animateChaiColorAsState
import com.droidconke.chai.utils.animateChaiAsState
import com.droidconke.chai.utils.chaiAnimationSpec

/**
 * Defines the ChaiDesign system TextStyle
 * This is the text style to be used by the client/across
 * the app instead of [TextStyle]. (Maybe implement a custom lint warning to enforce this?)
 * Example usage see ChaiDemo
 * @param color which is of type [ChaiColor]
 * @param size text size
 * @param weight text weight
 * @param letterSpacing the spacing of letters
 * @param textAlign TextAlignment by default is [TextAlign.Center]
 */
@Immutable
class ChaiTextStyle internal constructor(
    val color: ChaiColor = ChaiColor.ChaiBlack,
    val size: TextUnit,
    val weight: FontWeight,
    val letterSpacing: TextUnit = 0.sp,
    val fontFamily: FontFamily,
    val textAlign: TextAlign = TextAlign.Center
) {
    /**
     * Converts an instance of [ChaiTextStyle] into compose [TextStyle]
     * @return text style
     */
    @Stable
    internal fun asComposedStyle() = TextStyle(
        color = color.value,
        fontSize = size, fontWeight = weight, fontFamily = fontFamily,
        letterSpacing = letterSpacing, textAlign = textAlign
    )

    companion object {
        // annotating the variables with @Stable because it is a much stronger contract than val
        // note: compose compiler takes val to be unstable
        @Stable
        private val montserratRegular = FontFamily(Font(R.font.montserrat_regular))
        @Stable
        private val montserratThin = FontFamily(Font(R.font.montserrat_thin))
        @Stable
        val CActionStyle = ChaiTextStyle(
            color = ChaiColor.ChaiRed, size = 10.sp,
            weight = FontWeight.W700, fontFamily = montserratRegular
        )
        @Stable
        val CSubtitleStyle = ChaiTextStyle(
            color = ChaiColor.ChaiRed, size = 15.sp,
            fontFamily = montserratRegular, weight = FontWeight.W700
        )
        @Stable
        val CParagraphStyle = ChaiTextStyle(
            color = ChaiColor.ChaiBlack,
            size = 12.sp,
            fontFamily = montserratRegular, weight = FontWeight.W500
        )
        @Stable
        val CPageTitleStyle = ChaiTextStyle(
            color = ChaiColor.ChaiBlue,
            size = 33.sp,
            fontFamily = montserratThin, weight = FontWeight.W300
        )
    }

    /**
     * This method is appropriate for the times when a text style
     * is constructed but some properties need to be changed
     * @param color text color
     * @param weight font weight
     * @param textAlign alignment of text
     * @param fontFamily font family used by text
     * @return an instance of ChaiTextStyle
     */
    @Stable
    internal fun change(
        color: ChaiColor = this.color,
        weight: FontWeight = this.weight,
        textAlign: TextAlign = this.textAlign,
        fontFamily: FontFamily = this.fontFamily
    ) = ChaiTextStyle(
        color = color,
        weight = weight,
        letterSpacing = letterSpacing,
        fontFamily = fontFamily,
        size = size, textAlign = textAlign
    )
}

@OptIn(ExperimentalUnitApi::class)
@Stable
private fun Float.toSp() = TextUnit(value = this, type = TextUnitType.Sp)
/**
 * A [ChaiTextStyle] properties animator
 * Currently it animates only the [ChaiTextStyle.color] & [ChaiTextStyle.size] properties
 * @param targetValue the [ChaiTextStyle] to be animated
 * @param animationSpec animation spec to be used during the animation
 * @return [targetValue] returns an animated [ChaiTextStyle] in form of [State]
 */
@Suppress("UNCHECKED_CAST")
@Composable
internal fun animateChaiTextStyleAsState(
    targetValue: ChaiTextStyle,
    animationSpec: AnimationSpec<Any> = chaiAnimationSpec()
): State<ChaiTextStyle> {
    val targetColorAnimationState = animateChaiColorAsState(
        targetValue = targetValue.color,
        animationSpec = animationSpec as AnimationSpec<ChaiColor>
    )
    val targetSizeAnimationState = animateFloatAsState(
        targetValue = targetValue.size.value,
        animationSpec = animationSpec as AnimationSpec<Float>
    )
    return animateChaiAsState(
        initialValue = targetValue,
        animationStates = listOf(targetColorAnimationState, targetSizeAnimationState),
        targetBuilder = { animatedValues ->
            val (color, size) = animatedValues
            ChaiTextStyle(
                color = color as ChaiColor, size = (size as Float).toSp(),
                weight = targetValue.weight, letterSpacing = targetValue.letterSpacing, textAlign = targetValue.textAlign,
                fontFamily = targetValue.fontFamily
            )
        }
    )
}