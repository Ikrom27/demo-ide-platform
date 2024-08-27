package ru.ikrom.demo_ide_platform.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.ikrom.demo_ide_platform.ui.components.ScreenTitleBar

@Composable
fun ProductListScreen(){
    Scaffold(
        topBar = {
            ScreenTitleBar("Список товаров")
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(top = padding.calculateTopPadding())
        ) {

        }
        Text(text = "")
    }
}