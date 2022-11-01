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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.android254.presentation.common.theme.Montserrat
import com.droidconke.chai.atoms.type.MontserratBold
import java.util.*

@Composable
fun MultiToggleButton(
    currentSelections: String,
    toggleStates: List<String>,
    onToggleChange: (String) -> Int,
    modifier: Modifier = Modifier,
    borderSize: Dp = 1.dp,
    buttonHeight: Dp = 40.dp,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = selectedColor,
    border: BorderStroke = BorderStroke(borderSize, selectedColor),
    enabled: Boolean = true,
) {
    val unselectedColor = Color.Unspecified
    val selectedContentColor = MaterialTheme.colorScheme.onPrimary
    val unselectedContentColor = MaterialTheme.colorScheme.primary
    val chunkendOptions = toggleStates.chunked(3)
    val rowCount = chunkendOptions.size
    repeat(rowCount) {
        Row(modifier = modifier) {
            val squareCorner = CornerSize(0.dp)
            val selectionIndex = rememberSaveable() {
                mutableStateOf(0)
            }
            val buttonCount = chunkendOptions[it].size
            val shape = MaterialTheme.shapes.small


            repeat(buttonCount) { index ->
                val buttonShape = when (index) {
                    0 -> shape.copy(bottomEnd = squareCorner, topEnd = squareCorner)
                    buttonCount - 1 -> shape.copy(topStart = squareCorner, bottomStart = squareCorner)
                    else -> shape.copy(all = squareCorner)
                }
                val isButtonSelected = selectionIndex.value == index
                val backgroundColor = if (isButtonSelected) selectedColor else unselectedColor
                val contentColor =
                    if (isButtonSelected) selectedContentColor else unselectedContentColor
                val textStyle =
                    if (isButtonSelected) TextStyle(fontFamily = MontserratBold) else TextStyle(
                        fontFamily = Montserrat
                    )
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
                    enabled = enabled,
                    buttonTexts = chunkendOptions[it],
                    index = index,
                    contentColor = contentColor,
                    textStyle = textStyle,
                    onClick = {

                    },
                )
            }
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
    buttonTexts: List<String>,
    index: Int,
    contentColor: Color,
    onClick: () -> Unit,
    textStyle: TextStyle
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
            textStyle = textStyle,
            contentColor = contentColor,
        )
    }
}

@Composable
private fun RowScope.ButtonContent(
    buttonTexts: List<String>,
    index: Int,
    contentColor: Color,
    textStyle: TextStyle
) {
    when {
        buttonTexts.all { it != "" } -> TextContent(
            modifier = Modifier.align(Alignment.CenterVertically),
            buttonTexts = buttonTexts,
            index = index,
            contentColor = contentColor,
            textStyle = textStyle
        )
    }
}

@Composable
private fun TextContent(
    modifier: Modifier,
    buttonTexts: List<String>,
    index: Int,
    contentColor: Color,
    textStyle: TextStyle
) {
    Text(
        modifier = modifier.padding(horizontal = 8.dp),
        text = buttonTexts[index],
        color = contentColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = textStyle
    )
}