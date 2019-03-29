package com.kuzheevadel.daggerrxapp.network

import com.kuzheevadel.daggerrxapp.common.FlickrResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/services/rest/")
    fun getPhoto(@Query("method") method: String,
                 @Query("api_key") api_key: String,
                 @Query("format") format: String,
                 @Query("nojsoncallback") jsonCallback: String,
                 @Query("extras") url: String,
                 @Query("page") page: String,
                 @Query("text") text: String?): Observable<FlickrResponse>

}