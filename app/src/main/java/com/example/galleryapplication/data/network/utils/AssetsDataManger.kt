package com.example.galleryapplication.data.network.utils

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AssetsDataManger(val context: Context) {

    suspend inline fun <reified T> readRawJson(@RawRes rawResId: Int): T {
        val gson = Gson()
        context.resources.openRawResource(rawResId).bufferedReader().use {
            return gson.fromJson<T>(it, object : TypeToken<T>() {}.type)
        }
    }
}
