package ru.ikrom.demo_ide_platform.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import ru.ikrom.demo_ide_platform.data.models.ProductEntity
import ru.ikrom.demo_ide_platform.data.room.ProductDao

class LocalProductsDSImpl(private val productDao: ProductDao): ILocalProductsDS {
    override suspend fun getProducts(query: String): Flow<List<ProductEntity>> {
        return productDao.getProducts(query)
    }

    override suspend fun updateProduct(productEntity: ProductEntity) {
        productDao.updateProduct(productEntity)
    }

    override suspend fun deleteProduct(id: Int) {
        productDao.deleteProduct(id)
    }
}
