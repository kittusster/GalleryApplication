package com.example.galleryapplication.data.local

import com.example.galleryapplication.data.local.dao.ImageDao
import com.example.galleryapplication.data.local.entity.ImageEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: ImageDao) {
    suspend fun getImages(): List<ImageEntity> = dao.getAll()
    suspend fun saveImages(list: List<ImageEntity>) = dao.insertAll(list)
}
