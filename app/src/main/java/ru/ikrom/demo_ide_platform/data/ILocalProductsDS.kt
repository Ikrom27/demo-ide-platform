package ru.ikrom.demo_ide_platform.data

import ru.ikrom.demo_ide_platform.data.models.ProductEntity

interface ILocalProductsDS {
    suspend fun getProducts(): List<ProductEntity>
}