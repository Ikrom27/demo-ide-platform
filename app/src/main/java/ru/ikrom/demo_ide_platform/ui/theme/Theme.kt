package ru.ikrom.demo_ide_platform.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val LightColorScheme = lightColorScheme(
    primary = BlueDark,
    secondary = BlueLight,
    background = BackGround,
    surface = PinkLight,
    error = Red,
    surfaceBright = Color.White
)

@Composable
fun DemoideplatformTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme =LightColorScheme
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colorScheme.secondary)
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

}