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
package com.droidconke.chaidemo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidconke.chai.ChaiDCKE22Theme
import com.droidconke.chai.atoms.ChaiColor
import com.droidconke.chai.atoms.ChaiWhite
import com.droidconke.chai.components.*
import com.droidconke.chai.icons.ChaiIcon
import com.droidconke.chai.images.ChaiImage
import com.droidconke.chai.utils.BreathingSpace13
import com.droidconke.chai.utils.BreathingSpace26
import com.droidconke.chai.utils.SeparatorSpace

@Preview(showBackground = true)
@Composable
fun TextScreen() {

    ChaiDCKE22Theme {
        Column(
            Modifier
                .fillMaxSize()
                .background(color = ChaiColor.ChaiWhite.value)
                .padding(horizontal = 13.dp, vertical = 5.dp)
        ) {
            BreathingSpace26()
            ChaiPageTitle(text="Welcome Message")
            SeparatorSpace()
            ChaiSubtitle(text="dcke 2022 welcome remarks as subtitle")
            SeparatorSpace()
            ChaiParagraph(text="Welcome to droidconKE 2022. Lorem something something")
            BreathingSpace13()
            ChaiImage(modifier=Modifier,icon=ChaiIcon.FeedIcon,tint = ChaiColor.ChaiDarkGrey)
            BreathingSpace13()
            IconButton(onClick = {  }) { Icon(painter = painterResource(id = ChaiIcon.FeedIcon.drawableId), contentDescription = null)}
        }
    }
}