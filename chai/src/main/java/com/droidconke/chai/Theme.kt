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
package com.droidconke.chai

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.droidconke.chai.atoms.*

/**
 * Light and Dark Colors are Color ROles: https://m3.material.io/styles/color/the-color-system/color-roles
 * By mapping and coding roles through tokens, rather than assigning hex values,
 * a color can update systematically if a color palette changes. Tokens enable changes to a role's color value to cascade consistently.
 *
 * To understand the concept of these colors check here:
 * https://material.io/design/color/the-color-system.html#color-theme-creation
 * Will give clearer description later. But check the specific blocks for explanation of what they do
 *
 * USe this to generate these theme colours:
 * https://m3.material.io/theme-builder#/custom
 * */

private val ChaiLightColors = lightColorScheme(
/**
 * A primary color is the color displayed most frequently across your app's screens and components.
 * Primary base color
 * - On-primary is applied to content (icons, text, etc.) that sits on top of primary
 * - Primary container is applied to elements needing less emphasis than primary
 * - On-primary container is applied to content (icons, text, etc.) that sits on top of primary container
 *
 * For us its white and blue
 * */
    primary = ChaiBlue,
    onPrimary = ChaiWhite,
    primaryContainer = ChaiLightBlue,
    onPrimaryContainer = ChaiDarkBlue,
/**
 * A secondary color provides more ways to accent and distinguish your product.
 * Secondary roles are used for less prominent components in the UI, such as filter chips, while expanding the opportunity for color expression.
 * Your primary color can be used to make a color theme for your app, including dark and light primary color variants.
 * Just like the primary color, your secondary color can have dark and light variants.
 *
 * Secondary colors are used for:
 * - Floating action buttons
 * - Selection controls, like sliders and switches
 * - Highlighting selected text
 * -  Progress bars
 * - Links and headlines*
 * */
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = ChaiLightBlue,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,

    tertiary = md_theme_light_brandOrange,
    onTertiary = md_theme_light_onBrandOrange,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,

    /**
     * These are the error colors
     * */
    error =  ChaiDeepRed,
    onError = ChaiWhite,
    errorContainer = ChaiLighterRed,
    onErrorContainer = ChaiBrownRed,
/**
 *
 * The background color appears behind scrollable content.
 *
 * */
    background = ChaiWhite,
    onBackground = ChaiBlack,
/**
 * Surface colors affect the surfaces of components.
 * Surface, background, and error colors typically don’t represent brand.

 * */
    surface = ChaiLightGrey,
    onSurface = ChaiGrey,
    surfaceVariant = ChaiDarkGrey,
    onSurfaceVariant = ChaiDarkerGrey,

    outline = ChaiCoal,

    inverseSurface = md_theme_light_inverseSurface,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inversePrimary = md_theme_light_inversePrimary,

    surfaceTint = md_theme_light_surfaceTint,
)

private val ChaiDarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,

    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,

    tertiary = md_theme_light_brandOrange,
    onTertiary = md_theme_light_onBrandOrange,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,

    error = ChaiRed,
    onError = ChaiWhite,

    errorContainer = md_theme_dark_errorContainer,
    onErrorContainer = md_theme_dark_onErrorContainer,

    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,

    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,

    outline = ChaiWhite,

    inverseSurface = md_theme_dark_inverseSurface,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
)
@Composable
fun ChaiDCKE22Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> ChaiDarkColors
        else -> ChaiLightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val activity = view.context.findActivity()
            activity.window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

/**
 * Iterate through the context wrapper to find the closest activity associated with this context
 * This method is preferred to LocalContext.current as Activity
 * see [Theme.md](https://gist.github.com/GibsonRuitiari/7cb947228661993ee36d5c05b9e8f23f)
 * Throws [IllegalStateException] if no activity was found
 * @return an activity instance
 */
private fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("Activity absent")
}