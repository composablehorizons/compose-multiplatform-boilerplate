package org.example.project

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Text
import com.composeunstyled.focusRing
import com.composeunstyled.minimumInteractiveComponentSize
import com.composeunstyled.outline
import com.composeunstyled.theme.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(onClick: () -> Unit, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        modifier = modifier
            .minimumInteractiveComponentSize()
            .outline(1.dp, Theme[colors][outline], Theme[shapes][smallShape])
            .focusRing(interactionSource, 2.dp, Theme[colors][focusRing], Theme[shapes][smallShape]),
        backgroundColor = Theme[colors][primaryColor],
        contentColor = Theme[colors][onPrimaryColor],
        shape = Theme[shapes][smallShape],
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        content()
    }
}

@Composable
fun GhostButton(onClick: () -> Unit, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        modifier = modifier
            .minimumInteractiveComponentSize()
            .focusRing(interactionSource, 2.dp, Theme[colors][focusRing], Theme[shapes][smallShape]),
        backgroundColor = Color.Transparent,
        shape = Theme[shapes][smallShape],
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        content()
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    AppTheme {
        PrimaryButton(onClick = {}) {
            Text("Primary Button")
        }
    }
}

@Preview
@Composable
fun GhostButtonPreview() {
    AppTheme {
        GhostButton(onClick = {}) {
            Text("Ghost")
        }
    }
}