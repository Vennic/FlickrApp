package com.kuzheevadel.daggerrxapp.network

import com.kuzheevadel.daggerrxapp.common.FlickrResponse
import io.reactivex.Observable
import retrofit2.Retrofit

class NetworkService(retrofit: Retrofit) {

    private val apiKey = "a2151c9414f1522ffd1fa7ffee126670"
    private val getRecentMethod = "flickr.photos.getRecent"
    private val jsonFormat = "json"

    private val a = retrofit.create(ApiService::class.java)

    fun getPhotoList(): Observable<FlickrResponse> {

        return a.getPhoto(getRecentMethod, apiKey, jsonFormat, "1", "url_c", "1", null)
    }
}