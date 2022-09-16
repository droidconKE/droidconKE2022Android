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
package com.droidconke.chaidemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidconke.chai.ChaiDCKE22Theme
import com.droidconke.chai.atoms.ChaiWhite
import com.droidconke.chai.components.*
import com.droidconke.chai.utils.BreathingSpace13
import com.droidconke.chai.utils.BreathingSpace26
import com.droidconke.chai.utils.SeparatorSpace

@Preview(showBackground = true)
@Composable
fun ChaiDemo() {
    ChaiDCKE22Theme {
        Column(
            Modifier
                .fillMaxSize()
                .background(color = ChaiWhite)
                .padding(horizontal = 13.dp, vertical = 5.dp)
        ) {
            BreathingSpace26()
            CTitleBlue("Chai Demo")
            SeparatorSpace()
            CSubtitleRed("A catalog of the chai design system elements")
            SeparatorSpace()
            CParagraph("Check the code that is with each view")
            BreathingSpace13()
        }
    }
}