package ru.ikrom.demo_ide_platform.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ikrom.demo_ide_platform.data.ILocalProductsDS
import ru.ikrom.demo_ide_platform.data.IProductsRepository
import ru.ikrom.demo_ide_platform.data.LocalProductsDSImpl
import ru.ikrom.demo_ide_platform.data.ProductsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideProductsRepository(
        localDataSource: ILocalProductsDS
    ): IProductsRepository = ProductsRepositoryImpl(localDataSource)

    @Provides
    @Singleton
    fun provideLocalProductsDS(): ILocalProductsDS = LocalProductsDSImpl()
}