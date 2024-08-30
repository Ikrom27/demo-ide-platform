package ru.ikrom.demo_ide_platform.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.ikrom.demo_ide_platform.R
import ru.ikrom.demo_ide_platform.ui.cards.ProductCard
import ru.ikrom.demo_ide_platform.ui.components.AmountChangeDialog
import ru.ikrom.demo_ide_platform.ui.components.DeleteDialog
import ru.ikrom.demo_ide_platform.ui.components.ScreenTitleBar
import ru.ikrom.demo_ide_platform.ui.items.ProductItem
import ru.ikrom.demo_ide_platform.ui.theme.ICON_SMALL_PLUS
import ru.ikrom.demo_ide_platform.ui.theme.PADDING_BETWEEN_LARGE
import ru.ikrom.demo_ide_platform.viewmodels.ProductListViewModel

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel()
){
    var toDelete by remember {
        mutableStateOf<ProductItem?>(null)
    }
    var toChange by remember {
        mutableStateOf<ProductItem?>(null)
    }
    Scaffold(
        topBar = {
            ScreenTitleBar(stringResource(id = R.string.products_list))
        }
    ) { padding ->
        ProductList(
            viewModel = viewModel,
            onEdit = {toChange = it},
            onDelete = {toDelete = it},
            modifier = Modifier.padding(top = padding.calculateTopPadding()))
    }

    if(toDelete != null){
        DeleteDialog(
            onConfirm = {
                viewModel.deleteProduct(toDelete!!.id)
                toDelete = null
            },
            onDismiss = { toDelete = null}
        )
    }
    if(toChange != null) {
        AmountChangeDialog(
            amount = toChange!!.amount,
            onConfirm = {
                viewModel.updateProduct(toChange!!.copy(amount = it))
                toChange = null
            },
            onDismiss = { toChange = null })
    }
}

@Composable
private fun ProductList(
    viewModel: ProductListViewModel,
    onEdit: (ProductItem) -> Unit,
    onDelete: (ProductItem) -> Unit,
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
                    onEdit(it)
                },
                onDelete = { onDelete(it) }
            )
        }
    }
}