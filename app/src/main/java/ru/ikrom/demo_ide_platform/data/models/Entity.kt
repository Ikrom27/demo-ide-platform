package ru.ikrom.demo_ide_platform.data.models

import java.time.temporal.TemporalAmount


data class ProductEntity(
    val id: Int,
    val name: String,
    val time: Long,
    val tags: String,
    val amount: Int
)