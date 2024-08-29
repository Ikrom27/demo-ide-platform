package ru.ikrom.demo_ide_platform.data

import android.util.Log
import ru.ikrom.demo_ide_platform.data.models.ProductEntity
import ru.ikrom.demo_ide_platform.data.room.ProductDao

class LocalProductsDSImpl(private val productDao: ProductDao): ILocalProductsDS {
    override suspend fun getProducts(query: String): List<ProductEntity> {
        return productDao.getProducts(query).apply { Log.d("DS", this.size.toString()) }
    }
}
