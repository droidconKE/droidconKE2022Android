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
package com.droidconke.chai.atoms

import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import com.droidconke.chai.utils.chaiAnimationSpec
import kotlin.math.pow
import kotlin.reflect.KProperty

/**
 * these are the Primary colours from Chai's Design spec document
 */

val ChaiBlue = Color(0xFF000CEB)
val ChaiWhite = Color(0xFFFFFFFF)

/**
 * these are the Secondary colours from Chai's Design spec document
 */

val ChaiRed = Color(0xFFFF6E4D)
val ChaiTeal = Color(0xFF00e2c3)
val ChaiFadedLime = Color(0xFF7de1c3)

/**
 * these are the Neutrals from the Chai's Design spec document
 */

val ChaiLightGrey = Color(0xFFF5F5F5)
val ChaiGrey = Color(0xFFB1B1B1)
val ChaiDarkGrey = Color(0xFF5A5A5A)
val ChaiDarkerGrey = Color(0xFF191d1d)
val ChaiCoal = Color(0xFF20201E)
val ChaiBlack = Color(0xFF000000)

/**
 * Defines the colors to be used by the app
 * This an abstraction that contains all the colors (neutrals,primary & secondary)
 * needed by the application
 * A normal class, instead of data class, is used to prevent changing of the colors via copy
 * as that would lead to breaking of the intended app design system
 * Note: The color definition ought to be in Hex Color format
 * * Example usage see ChaiDemo
 * @param value the color value given by the client, the value is of a type [Color]
 */
@Immutable // since we are using an internal constructor, values read from [ChaiColor] won't change after an instance is constructed
@JvmInline
value class ChaiColor internal constructor(val value:Color){
    /**
     * Changes the alpha of the ChaiColor
     * @param alpha alpha in form float to be applied to current ChaiColor
     * @return an instance of ChaiColor with modified alpha value
     */
    fun changeAlpha(alpha:Float) = ChaiColor(value.copy(alpha=alpha))

    companion object{
        // should not be used in real components but,
        // can be used as a base value for ChaiColor
        @Stable
        internal val Unspecified = ChaiColor(value = Color.Unspecified)

        /* these are the Primary colours from Chai's Design spec document*/
        @Stable
        val ChaiBlue = ChaiColor(value=Color(0xFF000CEB))
        @Stable
        val ChaiWhite = ChaiColor(value = Color(0xFFFFFFFF))

        /* these are the Secondary colours from Chai's Design spec document */
        @Stable
        val ChaiRed = ChaiColor(value=Color(0xFFFF6E4D))
        @Stable
        val ChaiTeal = ChaiColor(value=Color(0xFF00e2c3))
        @Stable
        val ChaiFadedLime = ChaiColor(value=Color(0xFF7de1c3))

        /* these are the Neutrals from the Chai's Design spec document */
        @Stable
        val ChaiLightGrey = ChaiColor(value=Color(0xFFF5F5F5))
        @Stable
        val ChaiGrey = ChaiColor(value=Color(0xFFB1B1B1))
        @Stable
        val ChaiDarkGrey = ChaiColor(value=Color(0xFF5A5A5A))
        @Stable
        val ChaiDarkerGrey =ChaiColor(value= Color(0xFF191d1d))
        @Stable
        val ChaiCoal = ChaiColor(value=Color(0xFF20201E))
        @Stable
        val ChaiBlack = ChaiColor(value=Color(0xFF000000))

        /**
         * Typically colors are 3 dimensional planes i.e x,y,z
         * with the x being red, y being green and z blue
         * The three combined create a [ColorSpace] i.e a unique representation
         * of colors that can be created by combining the three pigments
         * To convert one color to the other, a mapping of these color spaces is needed
         * from [xyz] plane to another [xyz] plane.
         * for comprehensive explanation see [explanation] (https://en.wikipedia.org/wiki/Color_space)
         * note: adapted from aosp
         */
        private fun multiplyColumn(column:Int,x:Float,y:Float,
        z:Float,matrix:FloatArray) = x*matrix[column]+y*matrix[3+column]+z*matrix[6+column]
        private val M1 = floatArrayOf(
            0.80405736f,
            0.026893456f,
            0.04586542f,
            0.3188387f,
            0.9319606f,
            0.26299807f,
            -0.11419419f,
            0.05105356f,
            0.83999807f,
        )

        private val InverseM1 = floatArrayOf(
            1.2485008f,
            -0.032856926f,
            -0.057883114f,
            -0.48331892f,
            1.1044513f,
            -0.3194066f,
            0.19910365f,
            -0.07159331f,
            1.202023f,
        )
        internal val VectorConverter: (colorSpace: ColorSpace) -> TwoWayConverter<ChaiColor, AnimationVector4D> =
            { colorSpace ->
                TwoWayConverter(
                    convertToVector = { chaiColor ->
                        val color by chaiColor
                        val colorXyz = color.convert(
                            colorSpace = ColorSpaces.CieXyz,
                        )

                        val x = colorXyz.red
                        val y = colorXyz.green
                        val z = colorXyz.blue


                        val l = multiplyColumn(
                            column = 0,
                            x = x,
                            y = y,
                            z = z,
                            matrix = M1,
                        ).pow(
                            x = 1f / 3f,
                        )
                        val a = multiplyColumn(
                            column = 1,
                            x = x,
                            y = y,
                            z = z,
                            matrix = M1,
                        ).pow(
                            x = 1f / 3f,
                        )
                        val b = multiplyColumn(
                            column = 2,
                            x = x,
                            y = y,
                            z = z,
                            matrix = M1,
                        ).pow(
                            x = 1f / 3f,
                        )

                        AnimationVector4D(
                            v1 = color.alpha,
                            v2 = l,
                            v3 = a,
                            v4 = b,
                        )
                    },
                    convertFromVector = { vector ->
                        val l = vector.v2.pow(
                            x = 3f,
                        )
                        val a = vector.v3.pow(
                            x = 3f,
                        )
                        val b = vector.v4.pow(
                            x = 3f,
                        )

                        val x = multiplyColumn(
                            column = 0,
                            x = l,
                            y = a,
                            z = b,
                            matrix = InverseM1,
                        )
                        val y = multiplyColumn(
                            column = 1,
                            x = l,
                            y = a,
                            z = b,
                            matrix = InverseM1,
                        )
                        val z = multiplyColumn(
                            column = 2,
                            x = l,
                            y = a,
                            z = b,
                            matrix = InverseM1,
                        )

                        val colorXyz = Color(
                            alpha = vector.v1.coerceIn(
                                minimumValue = 0f,
                                maximumValue = 1f,
                            ),
                            red = x.coerceIn(
                                minimumValue = -2f,
                                maximumValue = 2f,
                            ),
                            green = y.coerceIn(
                                minimumValue = -2f,
                                maximumValue = 2f,
                            ),
                            blue = z.coerceIn(
                                minimumValue = -2f,
                                maximumValue = 2f,
                            ),
                            colorSpace = ColorSpaces.CieXyz,
                        )

                        ChaiColor(
                            value = colorXyz.convert(
                                colorSpace = colorSpace,
                            ),
                        )
                    }
                )
            }
    }
    operator fun getValue(thisRef:Any?,property:KProperty<*>) = value
}

/**
 * Constructs a color animation spec using [tween]
 * The duration millis is divided by 2 since color animation
 * more often than not will depend on other animations,
 * so it needs to run and complete before other animations to ensure a
 * smooth transition
 * @receiver animation spec to be used, ideally should be an instance of [TweenSpec]
 * @return a new instance of animation spec whose duration is divided by 2
 */
private fun <T>AnimationSpec<T>.toColorSpec():AnimationSpec<T>{
    val tweenSpec = this as TweenSpec<T> ?: return this
    return tween(durationMillis = tweenSpec.durationMillis/2,
    delayMillis = tweenSpec.delay,easing=tweenSpec.easing)
}
/**
 * This is supposed to be used to animate [ChaiColor] changes
 * @param targetValue an instance of [ChaiColor]
 * @param animationSpec animationSpec to be used when color change is detected/happens
 * @return state object of type [ChaiColor]
 */
@Composable
internal fun animateChaiColorAsState(targetValue:ChaiColor,animationSpec: AnimationSpec<ChaiColor> = chaiAnimationSpec()
):State<ChaiColor>{
    val converter = remember(key1 = targetValue.value.colorSpace) {
        (ChaiColor.VectorConverter)(targetValue.value.colorSpace)
    }
    return animateValueAsState(targetValue = targetValue,
        typeConverter =converter,
        animationSpec = animationSpec.toColorSpec(),
        finishedListener = null)
}
/**
 * TOBE Replaced
 */

val md_theme_light_primary = Color(0xFF005AC1)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFD8E2FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001A41)
val md_theme_light_secondary = Color(0xFF535E78)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFD8E2FF)
val md_theme_light_onSecondaryContainer = Color(0xFF0F1B32)
val md_theme_light_tertiary = Color(0xFF76517B)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFED6FF)
val md_theme_light_onTertiaryContainer = Color(0xFF2D0E34)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFEFBFF)
val md_theme_light_onBackground = Color(0xFF1B1B1F)
val md_theme_light_surface = Color(0xFFFEFBFF)
val md_theme_light_onSurface = Color(0xFF1B1B1F)
val md_theme_light_surfaceVariant = Color(0xFFE1E2EC)
val md_theme_light_onSurfaceVariant = Color(0xFF44474F)
val md_theme_light_outline = Color(0xFF74777F)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_inverseSurface = Color(0xFF303033)
val md_theme_light_inverseOnSurface = Color(0xFFF2F0F4)
val md_theme_light_inversePrimary = Color(0xFFADC6FF)
val md_theme_light_surfaceTint = Color(0xFF005AC1)
val md_theme_light_surfaceTintColor = Color(0xFF005AC1)
val md_theme_light_brandOrange = Color(0xFFFF6E4D)
val md_theme_light_onBrandOrange = Color(0xFFFFFFFF)

val md_theme_dark_primary = Color(0xFFADC6FF)
val md_theme_dark_onPrimary = Color(0xFF002E69)
val md_theme_dark_primaryContainer = Color(0xFF004494)
val md_theme_dark_onPrimaryContainer = Color(0xFFD8E2FF)
val md_theme_dark_secondary = Color(0xFFBBC6E4)
val md_theme_dark_onSecondary = Color(0xFF253048)
val md_theme_dark_secondaryContainer = Color(0xFF3B475F)
val md_theme_dark_onSecondaryContainer = Color(0xFFD8E2FF)
val md_theme_dark_tertiary = Color(0xFFE5B8E8)
val md_theme_dark_onTertiary = Color(0xFF44244A)
val md_theme_dark_tertiaryContainer = Color(0xFF5D3A62)
val md_theme_dark_onTertiaryContainer = Color(0xFFFED6FF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onErrorContainer = Color(0xFFFFB4AB)
val md_theme_dark_background = Color(0xFF1B1B1F)
val md_theme_dark_onBackground = Color(0xFFE3E2E6)
val md_theme_dark_surface = Color(0xFF1B1B1F)
val md_theme_dark_onSurface = Color(0xFFE3E2E6)
val md_theme_dark_surfaceVariant = Color(0xFF44474F)
val md_theme_dark_onSurfaceVariant = Color(0xFFC4C6D0)
val md_theme_dark_outline = Color(0xFF8E9099)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_inverseSurface = Color(0xFFE3E2E6)
val md_theme_dark_inverseOnSurface = Color(0xFF303033)
val md_theme_dark_inversePrimary = Color(0xFF005AC1)
val md_theme_dark_surfaceTint = Color(0xFFADC6FF)
val md_theme_dark_surfaceTintColor = Color(0xFFADC6FF)

val seed = Color(0xFF4285F4)