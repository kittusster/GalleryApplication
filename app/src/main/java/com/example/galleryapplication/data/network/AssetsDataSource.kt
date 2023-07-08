package com.example.galleryapplication.data.network

import com.example.galleryapplication.R
import com.example.galleryapplication.data.network.models.AssetImage
import com.example.galleryapplication.data.network.utils.AssetsDataManger
import javax.inject.Inject

class AssetsDataSource @Inject constructor(private val assetDataManger: AssetsDataManger) {
    suspend fun getImagesFromAssets() = assetDataManger.readRawJson<List<AssetImage>>(R.raw.image_assset)
}
