package ru.ikrom.demo_ide_platform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.ikrom.demo_ide_platform.data.IProductsRepository
import ru.ikrom.demo_ide_platform.data.models.Product
import ru.ikrom.demo_ide_platform.ui.items.DateUI
import ru.ikrom.demo_ide_platform.ui.items.ProductItem
import ru.ikrom.demo_ide_platform.ui.items.TagUI
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: IProductsRepository
): ViewModel() {
    private val _productList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productList: StateFlow<List<ProductItem>> = _productList

    fun updateListItems(query: String) {
        viewModelScope.launch {
            _productList.value = repository.getProducts(query).map { it.toItem() }
        }
    }

    private fun Product.toItem(): ProductItem {
        return ProductItem(
            name = name,
            amount = amount,
            date = DateUI(time),
            tags = tags.split("").map { TagUI(it) }
        )
    }
}