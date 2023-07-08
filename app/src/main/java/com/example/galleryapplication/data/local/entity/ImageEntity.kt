package com.example.galleryapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.galleryapplication.data.model.Image

@Entity("Image")
data class ImageEntity(
    var copyright: String? = null,
    var date: String? = null,
    var explanation: String? = null,
    var hdurl: String? = null,
    var mediaType: String? = null,
    var serviceVersion: String? = null,
    @PrimaryKey(autoGenerate = false) var title: String,
    var url: String? = null

)

fun ImageEntity.asExternalModel(): Image {
    return Image(
        copyright = this.copyright,
        date = this.date,
        explanation = this.explanation,
        hdurl = this.hdurl,
        mediaType = this.mediaType,
        serviceVersion = this.serviceVersion,
        title = this.title,
        url = this.url
    )
}
