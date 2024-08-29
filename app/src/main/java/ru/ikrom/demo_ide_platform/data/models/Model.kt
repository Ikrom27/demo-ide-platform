package ru.ikrom.demo_ide_platform.data.models


data class Product(
    val id: Int,
    val name: String,
    val amount: Int,
    val time: Long,
    val tags: String
)