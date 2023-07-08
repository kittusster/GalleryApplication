package com.example.test.data.network.di

import android.content.Context
import com.example.galleryapplication.data.network.utils.AssetsDataManger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AssetModule {
    @Singleton
    @Provides
    fun assetsDataManger(@ApplicationContext appContext: Context): AssetsDataManger {
        return AssetsDataManger(appContext)
    }
}
