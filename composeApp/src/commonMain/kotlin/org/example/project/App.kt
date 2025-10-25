package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.ArrowRight
import com.composables.icons.lucide.FileText
import com.composables.icons.lucide.Lightbulb
import com.composables.icons.lucide.Lucide
import com.composeunstyled.Icon
import com.composeunstyled.Text
import com.composeunstyled.theme.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    AppTheme {
        Column(
            modifier = Modifier
                .background(Theme[colors][backgroundColor])
                .fillMaxSize()
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.widthIn(max = 600.dp).fillMaxWidth().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text("Compose Unstyled", style = Theme[textStyles][headerStyle])

                Spacer(Modifier.height(16.dp))

                Text(buildAnnotatedString {
                    append("1. Edit ")
                    withStyle(SpanStyle(fontFamily = FontFamily.Monospace)) {
                        append("Theme.kt")
                    }
                    append(" to customize colors, typography and shape.")
                })
                Text(buildAnnotatedString {
                    append("2. View ")
                    withStyle(SpanStyle(fontFamily = FontFamily.Monospace)) {
                        append("Buttons.kt")
                    }
                    append(" to learn how to build themable components.")
                })

                Spacer(Modifier.height(4.dp))
                Row(
                    Modifier
                        .background(Color.Yellow.copy(0.1f), RoundedCornerShape(100))
                        .padding(8.dp)
                ) {
                    Icon(Lucide.Lightbulb, contentDescription = "Tip", modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("See your code changes instantly, by using the 'dev' config in your IDE")
                }

                Spacer(Modifier.height(16.dp))
                Row {
                    val uriHandler = LocalUriHandler.current

                    GhostButton(onClick = { uriHandler.openUri("https://composables.com/docs/compose-unstyled") }) {
                        Icon(Lucide.FileText, null, modifier = Modifier.size(16.dp))
                        Text("View Documentation")
                    }
                    Spacer(Modifier.size(8.dp))
                    PrimaryButton(onClick = { uriHandler.openUri("https://github.com/composablehorizons/compose-unstyled/discussions") }) {
                        Text("Visit Composables")
                        Icon(Lucide.ArrowRight, null, modifier = Modifier.size(16.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}