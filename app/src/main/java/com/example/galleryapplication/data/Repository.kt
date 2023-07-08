package com.example.galleryapplication.data

import com.example.galleryapplication.data.local.LocalDataSource
import com.example.galleryapplication.data.local.entity.asExternalModel
import com.example.galleryapplication.data.network.AssetsDataSource
import com.example.galleryapplication.data.network.models.AssetImage
import com.example.galleryapplication.data.network.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: AssetsDataSource,
    private val localDataSource: LocalDataSource
) {

    suspend fun getImagesFromAssets(): Flow<NetworkResult<List<AssetImage>>> {
        return flow {
            emit(NetworkResult.Loading())
            return@flow emit(NetworkResult.Success(remoteDataSource.getImagesFromAssets()))
        }.catch { exception ->
            emit(NetworkResult.Error(exception.message!!))
        }
            .flowOn(Dispatchers.IO)
    }

    suspend fun saveImages(images: List<AssetImage>) = localDataSource.saveImages(images.map { it.asEntity() })
    suspend fun getImagesFromDb() = localDataSource.getImages().map {
        it.asExternalModel()
    }
}
