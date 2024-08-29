package ru.ikrom.demo_ide_platform.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.ikrom.demo_ide_platform.data.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDataBase(): RoomDatabase() {
    abstract fun productDao(): ProductDao
}