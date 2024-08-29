package ru.ikrom.demo_ide_platform.data

import kotlinx.coroutines.flow.Flow
import ru.ikrom.demo_ide_platform.data.models.Product

interface IProductsRepository {
    suspend fun getProducts(query: String): Flow<List<Product>>
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(id: Int)
}