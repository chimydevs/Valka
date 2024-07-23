package com.chimy.valkaapp.di

import com.chimy.valkaapp.repository.HeroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHeroRepository(): HeroRepository {
        return HeroRepository()
    }
}