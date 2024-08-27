package ru.ikrom.demo_ide_platform.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    secondary = BlueSecondary,
    background = BackGround,
    surface = Surface,
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