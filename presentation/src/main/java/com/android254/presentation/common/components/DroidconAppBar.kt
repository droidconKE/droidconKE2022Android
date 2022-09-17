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
package com.android254.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.droidconke.chai.atoms.ChaiTeal

@Composable
fun DroidconAppBar(
    isSignedIn: Boolean = false,
    onActionClicked: () -> Unit = {},
    onFeedbackClicked: () -> Unit = {}
) {
    SmallTopAppBar(
        title = { Text("DroidconKE 22") },
        actions = {
            if (!isSignedIn) {
                Image(
                    painter = painterResource(id = R.drawable.whilte_padlock),
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = ChaiTeal,
                            shape = CircleShape
                        )
                        .width(30.dp)
                        .height(30.dp)
                        .padding(8.dp)
                        .clickable { onActionClicked() }
                )
            } else {
                Button(
                    onClick = onFeedbackClicked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ChaiTeal.copy(alpha = 0.21f),
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(4.dp),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(128.dp)
                        .height(30.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.smile),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(text = stringResource(id = R.string.feedback), fontSize = 12.sp)

                    Spacer(modifier = Modifier.width(10.dp))

                    Icon(
                        Icons.Default.Send,
                        contentDescription = null,
                        tint = ChaiTeal,
                        modifier = Modifier.size(12.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color.Black,
                            shape = CircleShape
                        )
                        .width(30.dp)
                        .height(30.dp)
                        .padding(4.dp)
                        .clickable { onActionClicked() }
                )
            }

            Spacer(modifier = Modifier.width(12.dp))
        }
    )
}

@Preview
@Composable
fun DroidconAppBarPreview() {
    DroidconKE2022Theme {
        DroidconAppBar()
    }
}

@Preview
@Composable
fun DroidconAppBarIsSignedInPreview() {
    DroidconKE2022Theme {
        DroidconAppBar(isSignedIn = true)
    }
}