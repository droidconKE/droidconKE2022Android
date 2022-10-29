package com.android254.presentation.feed.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android254.presentation.R
import com.droidconke.chai.atoms.ChaiBlue

@Composable
fun FeedShareSection() {
    Column(modifier = Modifier
        .fillMaxWidth()) {
        TextButton(
            onClick = {
            }
        ) {
            Text(
                text = stringResource(id = R.string.share),
                color = ChaiBlue,
                fontSize = MaterialTheme.typography.labelLarge.fontSize,
                fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                fontStyle = MaterialTheme.typography.labelLarge.fontStyle
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = stringResource(id = R.string.share),
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text(
            text = "CANCEL",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = MaterialTheme.typography.labelLarge.fontSize,
            fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
            fontStyle = MaterialTheme.typography.labelLarge.fontStyle
        )
    }
}