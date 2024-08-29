package ru.ikrom.demo_ide_platform.data

import ru.ikrom.demo_ide_platform.data.models.Product

interface IProductsRepository {
    suspend fun getProducts(query: String): List<Product>
}