package ru.ikrom.demo_ide_platform.data

import kotlinx.coroutines.flow.Flow
import ru.ikrom.demo_ide_platform.data.models.ProductEntity

interface ILocalProductsDS {
    suspend fun getProducts(query: String): Flow<List<ProductEntity>>
    suspend fun updateProduct(productEntity: ProductEntity)
    suspend fun deleteProduct(id: Int)
}