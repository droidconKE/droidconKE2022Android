package com.android254.presentation.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.droidconke.chai.atoms.type.MontserratBold
import com.droidconke.chai.atoms.type.MontserratSemiBold
import java.util.*

data class Filter<T>(
    val category: String,
    val options: List<T>
)

enum class FilterCategory(val resId: Int) {
    Level(R.string.title_filter_level),
    Topic(R.string.title_filter_topic),
    Room(R.string.title_filter_room),
    SessionType(R.string.title_filter_session_type),
}

data class FilterOption(
    val label: String,
    val value: String
)

class FilterAdapter(
    val categories: MutableMap<FilterCategory, List<FilterOption>>,
)

private fun createFilterAdapter(): FilterAdapter {
    return FilterAdapter(
        categories = mutableMapOf(
            FilterCategory.Level to loadLevels(),
            FilterCategory.Topic to loadTopics(),
            FilterCategory.Room to loadRooms(),
            FilterCategory.SessionType to loadSessionTypes(),
        )
    )
}

private fun loadSessionTypes(): List<FilterOption> {
    return listOf(
        FilterOption(
            label = "Keynote",
            value = "keynote"
        ),
        FilterOption(
            label = "Codelab",
            value = "codelab"
        ),
        FilterOption(
            label = "Session",
            value = "session"
        ),
        FilterOption(
            label = "Lightning Talk",
            value = "lightning"
        ),
        FilterOption(
            label = "Panel Discussion",
            value = "panel"
        ),
    )
}

private fun loadRooms(): List<FilterOption> {
    return listOf(
        FilterOption(
            label = "Room 1",
            value = "room_1"
        ),
        FilterOption(
            label = "Room 2",
            value = "room_2"
        ),
        FilterOption(
            label = "Room 3",
            value = "room_3"
        ),
    )
}

private fun loadTopics(): List<FilterOption> {
    return listOf(
        FilterOption(
            label = "UI/UX Design",
            value = "design"
        ),
        FilterOption(
            label = "Backend",
            value = "backend"
        ),
        FilterOption(
            label = "APIs",
            value = "api"
        )
    )
}

private fun loadLevels(): List<FilterOption> {
    return listOf(
        FilterOption(
            label = "beginner",
            value = "beginner"
        ),
        FilterOption(
            label = "intermediate",
            value = "intermediate"
        ),
        FilterOption(
            label = "expert",
            value = "expert"
        ),
    )
}

@Composable
fun SessionsFilterPanel(onDismiss: () -> Unit) {
    val filterTypeTextStyle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = MontserratBold
    )

    val currentSelection = rememberSaveable() {
        mutableStateOf("Beginner")
    }

    val filterCategories = createFilterAdapter()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 0.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Spacer(Modifier.weight(1f))
            TextButton(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancel")
            }
        }

        filterCategories.categories.forEach { filter ->
            Column(
                Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = filter.key.name,
                    style = filterTypeTextStyle,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(12.dp))
                MultiToggleButton(
                    currentSelections = currentSelection.value,
                    toggleStates = filter.value.map {
                        it.label
                    },
                    onToggleChange = { value ->
                        filter.value.map {
                            it.label
                        }.indexOf(value)
                    }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }

        Button(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "Filter".uppercase(),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = MontserratSemiBold,
                    letterSpacing = 2.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}