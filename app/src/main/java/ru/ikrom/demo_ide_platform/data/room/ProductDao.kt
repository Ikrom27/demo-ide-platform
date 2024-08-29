package ru.ikrom.demo_ide_platform.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.ikrom.demo_ide_platform.data.models.ProductEntity


@Dao
interface ProductDao {
    @Query("SELECT * from item where item.name LIKE :query || '%'")
    fun getProducts(query: String): Flow<List<ProductEntity>>

    @Update
    fun updateProduct(productEntity: ProductEntity)

    @Query("Delete from item where id = :id")
    fun deleteProduct(id: Int)
}