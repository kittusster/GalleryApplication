package com.example.galleryapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.galleryapplication.data.local.entity.ImageEntity

@Dao
interface ImageDao {
    @Query("SELECT * FROM Image")
    suspend fun getAll(): List<ImageEntity>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(users: List<ImageEntity>)
}
