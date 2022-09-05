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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.droidconke.chai.atoms.*
import com.droidconke.chai.atoms.MontserratRegular
import com.droidconke.chai.atoms.MontserratThin

/**
 * CText:
 * Typography( From  is the art of arranging letters and text in a way that makes the copy legible,
 * clear, and visually appealing to the reader.
 * It involves font style, appearance, and structure, which aims to elicit certain emotions and convey specific messages.
 * In short, typography is what brings the text to life.
 *
 * This is a shorter approach where our theme will not require a specific font BUT will use CText as a file to construct
 * our text. this is a shorter approach for making a Design system type. For a longer version see this repo:
 * [KahawaLove](https://github.com/tamzi/KahawaLove).
 *
 *
 * */

/**
 * Title based fonts
 * */

@Composable
fun CPageTitle(pageTitle: String) {
    Text(
        text = pageTitle,
        style = TextStyle(
            color = ChaiBlue,
            fontSize = 33.sp,
            fontWeight = FontWeight.W300,
            fontFamily = MontserratThin,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CSubtitleRed(dSubtitle: String) {
    Text(
        text = dSubtitle,
        style = TextStyle(
            color = ChaiRed,
            fontSize = 15.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CTopicBlue(dTopic: String) {
    Text(
        text = dTopic,
        style = TextStyle(
            color = ChaiBlue,
            fontSize = 21.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratBold,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CSubTopicBlue(dSubTopic: String) {
    Text(
        text = dSubTopic,
        style = TextStyle(
            color = ChaiBlue,
            fontSize = 17.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
            ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CSubTopicThinBlue(dSubTopicThin: String) {
    Text(
        text = dSubTopicThin,
        style = TextStyle(
            color = ChaiBlue,
            fontSize = 17.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratMedium,
            ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CSubTopicWhite(dSubTopic: String) {
    Text(
        text = dSubTopic,
        style = TextStyle(
            color = ChaiWhite,
            fontSize = 17.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
            ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CSubTopicRed(dSubTopic: String) {
    Text(
        text = dSubTopic,
        style = TextStyle(
            color = ChaiRed,
            fontSize = 17.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

/**
 * Explanation based fonts
 * */
@Composable
fun CHintBlack(dHint: String) {
    Text(
        text = dHint,
        style = TextStyle(
            color = ChaiBlack,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            fontFamily = MontserratLight,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}



/**
 * Button texts
 * */
@Composable
fun CButtonBlack(cButtonBlack: String) {
    Text(
        text = cButtonBlack,
        style = TextStyle(
            color = ChaiBlack,
            fontSize = 14.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
            ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CButtonThinBlack(cButtonBlack: String) {
    Text(
        text = cButtonBlack,
        style = TextStyle(
            color = ChaiBlack,
            fontSize = 12.sp,
            fontWeight = FontWeight.W200,
            fontFamily = MontserratRegular,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CButtonThinBlue(cButtonBlue: String) {
    Text(
        text = cButtonBlue,
        style = TextStyle(
            color = ChaiBlue,
            fontSize = 12.sp,
            fontWeight = FontWeight.W200,
            fontFamily = MontserratRegular,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CBottomMenuButtonBlack(cBottomMenuButtonBlack: String) {
    Text(
        text = cBottomMenuButtonBlack,
        style = TextStyle(
            color = ChaiBlack,
            fontSize = 9.sp,
            fontWeight = FontWeight.W200,
            fontFamily = MontserratLight,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CButtonWhite(cButtonWhite: String) {
    Text(
        text = cButtonWhite,
        style = TextStyle(
            color = ChaiWhite,
            fontSize = 14.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
            ),
        modifier = Modifier.fillMaxWidth()
    )
}

/**
 * Flat Button texts
 * */
@Composable
fun CActionUnderlineRed(cActionRedText: String) {
    Text(
        text = cActionRedText,
        style = TextStyle(
            color = ChaiRed,
            fontSize = 15.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
            textDecoration = TextDecoration.Underline,
            ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CActionBlack(ActionBlackText: String) {
    Text(
        text = ActionBlackText,
        style = TextStyle(
            color = ChaiBlack,
            fontSize = 15.sp,
            fontWeight = FontWeight.W700,
            fontFamily = MontserratRegular,
            ),
        modifier = Modifier.fillMaxWidth()
    )
}


/**
 * paragraph based fonts
 * */
@Composable
fun CParagraph(dParagraph: String) {
    Text(
        text = dParagraph,
        style = TextStyle(
            color = ChaiBlack,
            fontSize = 13.sp,
            fontWeight = FontWeight.W500,
            fontFamily = MontserratRegular,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CParagraphTextRed(dParagraph: String) {
    Text(
        text = dParagraph,
        style = TextStyle(
            color = ChaiBlack,
            fontSize = 13.sp,
            fontWeight = FontWeight.W500,
            fontFamily = MontserratRegular,
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

