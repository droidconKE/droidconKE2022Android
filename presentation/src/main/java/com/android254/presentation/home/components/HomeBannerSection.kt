package com.android254.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.droidconke.chai.atoms.ChaiBlack
import com.droidconke.chai.atoms.ChaiTeal
import com.droidconke.chai.atoms.ChaiWhite
import com.droidconke.chai.atoms.type.MontserratBold
import com.droidconke.chai.atoms.type.MontserratRegular

@Composable
fun HomeBannerSection() {
    HomeSpacer()
    HomeEventBanner()
    HomeSpacer()
    HomeCallForSpeakersLink()
}

@Composable
fun HomeEventBanner() {
    Image(
        painter = painterResource(id = R.drawable.droidcon_event_banner),
        contentDescription = stringResource(id = R.string.home_banner_event_poster_description),
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun HomeCallForSpeakersLink() {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth().aspectRatio(4.2f),
        colors = CardDefaults.cardColors(containerColor = ChaiTeal)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home_speakers_card_drawable),
                contentDescription = stringResource(id = R.string.home_banner_call_for_speakers_image_description),
                modifier = Modifier.padding(start = 15.dp, end = 19.dp),
                tint = Color.Unspecified
            )

            Column(
                modifier = Modifier.fillMaxHeight().padding(end = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.home_banner_call_for_speakers_label),
                    fontFamily = MontserratBold,
                    color = ChaiWhite,
                    fontSize = 17.sp
                )
                Text(
                    text = stringResource(id = R.string.home_banner_call_for_speakers_apply_to_speak_label),
                    fontFamily = MontserratRegular,
                    color = ChaiBlack,
                    fontSize = 10.sp
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_home_speakers_card_play),
                contentDescription = stringResource(id = R.string.home_banner_call_for_speakers_image_description),
                modifier = Modifier.align(Alignment.CenterVertically),
                tint = ChaiWhite
            )
        }
    }
}

@Preview
@Composable
fun HomeBannerSectionPreview() {
    DroidconKE2022Theme {
        HomeBannerSection()
    }
}

@Preview
@Composable
fun HomeEventBannerPreview() {
    DroidconKE2022Theme {
        HomeEventBanner()
    }
}

@Preview
@Composable
fun HomeCallForSpeakersLinkPreview() {
    DroidconKE2022Theme {
        HomeCallForSpeakersLink()
    }
}