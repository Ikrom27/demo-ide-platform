package ru.ikrom.demo_ide_platform.data

import ru.ikrom.demo_ide_platform.data.models.ProductEntity
import ru.ikrom.demo_ide_platform.data.room.ProductDao

class LocalProductsDSImpl(private val productDao: ProductDao): ILocalProductsDS {
    override suspend fun getProducts(query: String): List<ProductEntity> {
        productDao
        return fake
    }
}

val fake = listOf(
    ProductEntity(
        id = 1,
        name = "Телефон",
        time = 1633046400000L, // Пример времени в миллисекундах
        tags = "[\"Электроника\", \"Новый\"]",
        amount = 10
    ),
    ProductEntity(
        id = 2,
        name = "Ноутбук",
        time = 1635724800000L,
        tags = "[\"Компьютеры\", \"Распродажа\"]",
        amount = 5
    ),
    ProductEntity(
        id = 3,
        name = "Наушники",
        time = 1638316800000L,
        tags = "[\"Аксессуары\", \"Новый\"]",
        amount = 15
    ),
    ProductEntity(
        id = 4,
        name = "Часы",
        time = 1640995200000L,
        tags = "[\"Электроника\", \"Распродажа\"]",
        amount = 8
    ),
    ProductEntity(
        id = 5,
        name = "Клавиатура",
        time = 1643673600000L,
        tags = "[\"Компьютеры\", \"Новый\"]",
        amount = 20
    )
)