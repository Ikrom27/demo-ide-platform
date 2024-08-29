package ru.ikrom.demo_ide_platform.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.temporal.TemporalAmount

@Entity(tableName = "item")
data class ProductEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "time") val time: Long,
    @ColumnInfo(name = "tags") val tags: String,
    @ColumnInfo(name = "amount") val amount: Int
)