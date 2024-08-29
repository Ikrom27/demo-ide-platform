package ru.ikrom.demo_ide_platform.data.models


data class Product(
    val name: String,
    val amount: Int,
    val time: Long,
    val tags: String
)

fun ProductEntity.toModel(): Product {
    return Product(name, amount, time, tags)
}