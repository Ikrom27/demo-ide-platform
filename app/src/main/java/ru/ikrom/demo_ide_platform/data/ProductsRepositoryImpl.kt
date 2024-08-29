package ru.ikrom.demo_ide_platform.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.ikrom.demo_ide_platform.data.models.Product
import ru.ikrom.demo_ide_platform.data.models.ProductEntity
import javax.inject.Inject


class ProductsRepositoryImpl @Inject constructor(
    private val localDataSource: ILocalProductsDS
): IProductsRepository {
    override suspend fun getProducts(query: String): Flow<List<Product>> {
        return localDataSource.getProducts(query).map { list ->
            list.map {  it.toModel() }
        }
    }

    override suspend fun updateProduct(product: Product) {
        localDataSource.updateProduct(product.toEntity())
    }

    override suspend fun deleteProduct(id: Int) {
        localDataSource.deleteProduct(id)
    }

    private fun ProductEntity.toModel(): Product {
        return Product(id, name, amount, time, tags)
    }

    private fun Product.toEntity(): ProductEntity {
        return ProductEntity(
            id = this.id,
            name = this.name,
            time = this.time,
            tags = this.tags,
            amount = this.amount
        )
    }
}