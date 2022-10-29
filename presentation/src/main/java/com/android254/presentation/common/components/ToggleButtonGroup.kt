package com.android254.presentation.common.components

import android.widget.ToggleButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import java.util.*

@Composable
fun MultiToggleButton(
    currentSelection: String,
    toggleStates: Array<String>,
    onToggleChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    borderSize: Dp = 1.dp,
    buttonHeight: Dp = 40.dp,
    selectedColor: Color = MaterialTheme.colorScheme.secondary,
    borderColor: Color = selectedColor,
    border: BorderStroke = BorderStroke(borderSize, selectedColor),

    ) {
//    val selectedColor = MaterialTheme.colorScheme.primary
    val unselectedColor = Color.Unspecified
    val selectedContentColor = Color.Red
    val unselectedContentColor = Color.Blue
    Row(modifier = modifier) {
        val squareCorner = CornerSize(0.dp)
        var selectionIndex = 0
        val buttonCount = toggleStates.size
        val shape = MaterialTheme.shapes.small
        repeat(buttonCount) { index ->
            val buttonShape = when (index) {
                0 -> shape.copy(bottomEnd = squareCorner, topEnd = squareCorner)
                buttonCount - 1 -> shape.copy(topStart = squareCorner, bottomStart = squareCorner)
                else -> shape.copy(all = squareCorner)
            }
            val isButtonSelected = selectionIndex == index
            val backgroundColor = if (isButtonSelected) selectedColor else unselectedColor
            val contentColor = if (isButtonSelected) selectedContentColor else unselectedContentColor
            val offset = borderSize * -index

            ToggleButton(
                modifier = Modifier
                    .weight(weight = 1f)
                    .defaultMinSize(minHeight = buttonHeight)
                    .offset(x = offset),
                buttonShape = buttonShape,
                border = border,
                backgroundColor = backgroundColor,
                elevation = ButtonDefaults.buttonElevation(),
                enabled = true,
                buttonTexts = toggleStates,
                index = index,
                contentColor = contentColor,
                onClick = {
                    selectionIndex = index
                    onToggleChange.invoke(index.toString())
                },
            )
        }
    }
}


@Composable
private fun ToggleButton(
    modifier: Modifier,
    buttonShape: CornerBasedShape,
    border: BorderStroke,
    backgroundColor: Color,
    elevation: ButtonElevation,
    enabled: Boolean,
    buttonTexts: Array<String>,
    index: Int,
    contentColor: Color,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        contentPadding = PaddingValues(),
        shape = buttonShape,
        border = border,
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(containerColor = backgroundColor),
        elevation = elevation,
        enabled = enabled,
    ) {
        ButtonContent(
            buttonTexts = buttonTexts,
            index = index,
            contentColor = contentColor,
        )
    }
}

@Composable
private fun RowScope.ButtonContent(
    buttonTexts: Array<String>,
    index: Int,
    contentColor: Color,
) {
    when {
        buttonTexts.all { it != "" } -> TextContent(
            modifier = Modifier.align(Alignment.CenterVertically),
            buttonTexts = buttonTexts,
            index = index,
            contentColor = contentColor,
        )
    }
}

@Composable
private fun TextContent(
    modifier: Modifier,
    buttonTexts: Array<String>,
    index: Int,
    contentColor: Color
) {
    Text(
        modifier = modifier.padding(horizontal = 8.dp),
        text = buttonTexts[index],
        color = contentColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}