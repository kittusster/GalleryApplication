package com.example.galleryapplication.data.network.models

import com.example.galleryapplication.data.local.entity.ImageEntity
import com.google.gson.annotations.SerializedName

data class AssetImage(
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("explanation") var explanation: String? = null,
    @SerializedName("hdurl") var hdurl: String? = null,
    @SerializedName("media_type") var mediaType: String? = null,
    @SerializedName("service_version") var serviceVersion: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("url") var url: String? = null

) {
    fun asEntity(): ImageEntity {
        return ImageEntity(
            copyright = this.copyright,
            date = this.date,
            explanation = this.explanation,
            hdurl = this.hdurl,
            mediaType = this.mediaType,
            serviceVersion = this.serviceVersion,
            title = this.title!!,
            url = this.url
        )
    }
}
