package com.android254.presentation.sessions.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android254.presentation.common.components.EventDaySelectorButton
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class EventDate(
    val value: LocalDate
)

@RequiresApi(Build.VERSION_CODES.O)
val droidconEventDays = listOf(
    EventDate(LocalDate.parse("2022-11-16")),
    EventDate(LocalDate.parse("2022-11-17")),
    EventDate(LocalDate.parse("2022-11-18")),
)

@RequiresApi(Build.VERSION_CODES.O)
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd");

fun ordinal(i: Int): String {
    val suffixes = arrayOf("th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th")
    return when (i % 100) {
        11, 12, 13 -> i.toString() + "th"
        else -> i.toString() + suffixes[i % 10]
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventDaySelector(
    selected: String = droidconEventDays.first().value.format(
        DateTimeFormatter.ofPattern(
            "dd-MM-yyyy"
        )
    ),
    onSelect: (LocalDate) -> Unit = {}
) {
    Row() {
        droidconEventDays.forEachIndexed { index, eventDate ->
            EventDaySelectorButton(
                title = ordinal(eventDate.value.format(formatter).toInt()),
                subtitle = "Day ${index + 1}",
                onClick = { onSelect(eventDate.value) },
                selected = eventDate.value.format(formatter) == selected
            ) {
            }
            Spacer(Modifier.width(16.dp))
        }
    }
}