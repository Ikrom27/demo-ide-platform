package ru.ikrom.demo_ide_platform.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import ru.ikrom.demo_ide_platform.R
import ru.ikrom.demo_ide_platform.ui.cards.ProductCard
import ru.ikrom.demo_ide_platform.ui.components.ScreenTitleBar
import ru.ikrom.demo_ide_platform.ui.items.ProductItem
import ru.ikrom.demo_ide_platform.ui.theme.ICON_MEDIUM
import ru.ikrom.demo_ide_platform.ui.theme.ICON_SMALL_PLUS
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_LARGE
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_LARGE
import ru.ikrom.demo_ide_platform.ui.theme.RADIUS_DIALOG_CORNER
import ru.ikrom.demo_ide_platform.viewmodels.ProductListViewModel

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel()
){
    var toDelete by remember {
        mutableStateOf<ProductItem?>(null)
    }
    Scaffold(
        topBar = {
            ScreenTitleBar(stringResource(id = R.string.products_list))
        }
    ) { padding ->
        ProductList(
            viewModel = viewModel,
            toDelete = {toDelete = it},
            modifier = Modifier.padding(top = padding.calculateTopPadding()))
    }

    if(toDelete != null){
        deleteDialog(
            onConfirm = {
                viewModel.deleteProduct(toDelete!!.id)
                toDelete = null
            },
            onDismiss = { toDelete = null}
        )
    }
}

@Composable
private fun ProductList(
    viewModel: ProductListViewModel,
    toDelete: (ProductItem) -> Unit,
    modifier: Modifier,
){
    var searchField by remember { mutableStateOf("") }
    val products by viewModel.productList.collectAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_LARGE),
        contentPadding = PaddingValues(vertical = PADDING_BETWEEN_LARGE),
        modifier = modifier
            .padding(horizontal = 14.dp)
    ) {
        item {
            OutlinedTextField(
                value = searchField,
                onValueChange = {
                    searchField = it
                    viewModel.updateListItems(it)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier.size(ICON_SMALL_PLUS)
                    )
                },
                label = {Text(stringResource(id = R.string.search_products))},
                modifier = Modifier.fillMaxWidth()
            )
        }

        items(items = products){
            ProductCard(
                product = it,
                onEdit = {
                    viewModel.updateProduct(it.copy(amount = it.amount+1))
                },
                onDelete = { toDelete(it) }
            )
        }
    }
}

@Composable
fun deleteDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(RADIUS_DIALOG_CORNER)
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(PADDING_BETWEEN_LARGE),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(PADDING_LARGE))
            {
                Icon(
                    painter = painterResource(id = R.drawable.ic_dangerous),
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(ICON_MEDIUM))
                Text(
                    text = stringResource(id = R.string.delete_product),
                    style = MaterialTheme.typography.bodyLarge.copy(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = stringResource(id = R.string.delete_text),
                    style = MaterialTheme.typography.bodyLarge.copy(),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth())
                {
                    IconButton(onClick = onDismiss) {
                        Text(
                            text = stringResource(id = R.string.no),
                            style = MaterialTheme.typography.bodyLarge.copy(),
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                    IconButton(onClick = onConfirm) {
                        Text(
                            text = stringResource(id = R.string.yes),
                            style = MaterialTheme.typography.bodyLarge.copy(),
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}