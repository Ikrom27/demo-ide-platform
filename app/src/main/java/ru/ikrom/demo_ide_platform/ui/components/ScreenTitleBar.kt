package ru.ikrom.demo_ide_platform.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ScreenTitleBar(title: String){
    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.secondary)
        .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
                                .padding(vertical = 20.dp)
            )
    }
}