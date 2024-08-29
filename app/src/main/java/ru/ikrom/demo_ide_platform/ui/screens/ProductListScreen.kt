package ru.ikrom.demo_ide_platform.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ikrom.demo_ide_platform.ui.components.ScreenTitleBar

@Composable
fun ProductListScreen(){

    Scaffold(
        topBar = {
            ScreenTitleBar("Список товаров")
        }
    ) { padding ->
        ProductList(Modifier.padding(top = padding.calculateTopPadding()))
    }
}

@Composable
private fun ProductList(modifier: Modifier){
    var searchField by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .padding(vertical = 14.dp, horizontal = 14.dp)
    ) {
        item {
            OutlinedTextField(
                value = searchField,
                onValueChange = {
                    searchField = it
                    Log.d("Seach", searchField)
                },
                label = {Text("Поиск")},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}