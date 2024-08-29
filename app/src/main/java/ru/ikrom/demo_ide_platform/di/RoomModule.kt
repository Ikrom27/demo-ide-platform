package ru.ikrom.demo_ide_platform.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.ikrom.demo_ide_platform.data.room.AppDataBase
import ru.ikrom.demo_ide_platform.data.room.ProductDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "app_database",
        )
            .createFromAsset("data.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideProductDao(db: AppDataBase): ProductDao = db.productDao()
}