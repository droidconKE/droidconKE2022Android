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

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.droidconke.chai.R


/**
 * Chai typography:
 * Consists of 2 files that work together:
 *  - CTypography(located ion the components package) and
 *  - CFont located in the atoms directory
 * Type:
 * Defines the font family types only here
 * We use val for the purpose of making it available in the entire application
 * You first add the fonts to the res folder under fonts
 * Then just reference them here.
 * Font-  List all fonts that will be used in the application
 * CTypography - is the art of arranging letters and text in a way that makes the copy legible, clear, and visually appealing to the reader.
 * It involves font style, appearance, and structure, which aims to elicit certain emotions and convey specific messages.
 * In short, typography is what brings the text to life.
 *
 */

val Montserrat = FontFamily(
    Font(R.font.montserrat_black),
    Font(R.font.montserrat_black_italic),
    Font(R.font.montserrat_bold),
    Font(R.font.montserrat_bold_italic),
    Font(R.font.montserrat_extra_bold),
    Font(R.font.montserrat_extra_bold_italic),
    Font(R.font.montserrat_extra_light),
    Font(R.font.montserrat_extra_light_italic),
    Font(R.font.montserrat_italic),
    Font(R.font.montserrat_light),
    Font(R.font.montserrat_light_italic),
    Font(R.font.montserrat_medium),
    Font(R.font.montserrat_medium_italic),
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_semi_bold),
    Font(R.font.montserrat_semi_bold_italic),
    Font(R.font.montserrat_thin),
    Font(R.font.montserrat_thin_italic),
)
