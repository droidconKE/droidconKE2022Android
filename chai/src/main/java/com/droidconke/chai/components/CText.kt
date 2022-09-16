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

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.droidconke.chai.atoms.ChaiColor
import com.droidconke.chai.utils.AnimateContentChange

/**
 * CText:
 * Typography( From  is the art of arranging letters and text in a way that makes the copy legible,
 * clear, and visually appealing to the reader.
 * It involves font style, appearance, and structure, which aims to elicit certain emotions and convey specific messages.
 * In short, typography is what brings the text to life.
 *
 * This is a shorter approach where our theme will not require a specific font BUT will use CText as a file to construct
 * our text. this is a shorter approach for making a Design system type. For a longer version see this repo:
 * [KahawaLove](https://github.com/tamzi/KahawaLove)
 *
 * */



/**
 * Basic Text Construct, that adheres to the app's design system,
 * which is to be used by clients whenever they need
 * a text component in their composables
 * @param modifier modifier to be applied to the text component
 * @param style ChaiTextStyle design to be applied, note the design includes
 * the font-family+weight, color, and text size
 * @param singleLine whether this text is a single line
 */
@Composable
internal fun ChaiText(modifier: Modifier=Modifier,text:String,
style: ChaiTextStyle,singleLine:Boolean=true){
    val styleAnimationState by animateChaiTextStyleAsState(targetValue = style)
    Text(text = text, style = styleAnimationState.asComposedStyle(),
    modifier = modifier, maxLines = when(singleLine){
        true->1
        else->Int.MAX_VALUE
    })
}
/**
 * Basic Text Construct that construct an animated text, and adheres to the app's design system,
 * This is to be used by clients whenever they need a text component in their composables
 * @param modifier modifier to be applied to the text component
 * @param style ChaiTextStyle design to be applied, note the design includes
 * the font-family+weight, color, and text size
 * @param singleLine whether this text is a single line
 */
@Composable
internal fun AnimatedChaiText(modifier: Modifier=Modifier,
                              text: String,
                              style: ChaiTextStyle,
                              singleLine: Boolean=true){
    val styleAnimationState by animateChaiTextStyleAsState(targetValue = style)
    AnimateContentChange(targetState = text, modifier = modifier) {animatedText->
        Text(text = animatedText, style = styleAnimationState.asComposedStyle(),maxLines = when(singleLine){
                true->1
                else->Int.MAX_VALUE
            })
    }
}


/**
 * Title based fonts
 * */

@Composable
//directly calls another composable thus we need to tell compiler to skip this during recomposition
@NonRestartableComposable
fun ChaiParagraph(modifier: Modifier=Modifier,
                      text:String,
                      color: ChaiColor = ChaiColor.ChaiBlack)= ChaiText(
    modifier=modifier,
    text = text,
    style = ChaiTextStyle.CParagraphStyle.change(color=color)
)

@Composable
@NonRestartableComposable
fun ChaiPageTitle(modifier:Modifier=Modifier,
                  text: String,
                  color: ChaiColor = ChaiColor.ChaiCoal) = AnimatedChaiText(
    text = text,
    modifier=modifier,
    style = ChaiTextStyle.CPageTitleStyle.change(color=color))

@Composable
@NonRestartableComposable
fun ChaiSubtitle(modifier: Modifier=Modifier,text: String,color: ChaiColor= ChaiColor.ChaiBlack) =
     ChaiText(text = text, modifier = modifier, style= ChaiTextStyle.CSubtitleStyle.change(color=color) )

//@Composable
//fun CParagraph(dParagraph: String) {
//    Text(
//        text = dParagraph,
//        style = TextStyle(
//            color = ChaiBlack,
//            fontSize = 12.sp,
//            fontWeight = FontWeight.W500,
//            fontFamily = MontserratRegular,
//        ),
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun CPageTitle(pageTitle: String) {
//    Text(
//        text = pageTitle,
//        style = TextStyle(
//            color = ChaiBlue,
//            fontSize = 33.sp,
//            fontWeight = FontWeight.W300,
//            fontFamily = MontserratThin,
//
//        ),
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun CSubtitle(dSubtitle: String) {
//    Text(
//        text = dSubtitle,
//        style = TextStyle(
//            color = ChaiRed,
//            fontSize = 15.sp,
//            fontWeight = FontWeight.W700,
//            fontFamily = MontserratRegular,
//
//        ),
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun CActionText(cAction: String) {
//    Text(
//        text = cAction,
//        style = TextStyle(
//            color = ChaiRed,
//            fontSize = 15.sp,
//            fontWeight = FontWeight.W700,
//            fontFamily = MontserratRegular,
//
//        ),
//        modifier = Modifier.fillMaxWidth()
//    )
//}


