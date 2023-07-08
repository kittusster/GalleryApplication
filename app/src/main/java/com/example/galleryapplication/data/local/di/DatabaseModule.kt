package com.example.galleryapplication.data.local.di

import android.content.Context
import com.example.galleryapplication.data.local.AppDatabase
import com.example.galleryapplication.data.local.dao.ImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(appContext)
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase?): ImageDao {
        return appDatabase!!.userDao()
    }
}
