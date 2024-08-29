package ru.ikrom.demo_ide_platform.data

import ru.ikrom.demo_ide_platform.data.models.Product
import ru.ikrom.demo_ide_platform.data.models.ProductEntity
import javax.inject.Inject


class ProductsRepositoryImpl @Inject constructor(
    private val localDataSource: ILocalProductsDS
): IProductsRepository {
    override suspend fun getProducts(query: String): List<Product> {
        return localDataSource.getProducts(query).map { it.toModel() }
    }

    private fun ProductEntity.toModel(): Product {
        return Product(name, amount, time, tags)
    }
}