package ru.ikrom.demo_ide_platform.data.room

import androidx.room.Dao
import androidx.room.Query
import ru.ikrom.demo_ide_platform.data.models.ProductEntity


@Dao
interface ProductDao {
    @Query("SELECT * from item where item.name LIKE :query || '%'")
    fun getProducts(query: String): List<ProductEntity>
}