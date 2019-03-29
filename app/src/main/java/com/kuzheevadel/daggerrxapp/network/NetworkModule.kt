package com.kuzheevadel.daggerrxapp.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kuzheevadel.daggerrxapp.common.FlickrResponse
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    private val BASE_URL = "https://api.flickr.com"

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor { chain ->
            val requestOriginal = chain.request()
            val originalUrl = requestOriginal.url()
            val url = originalUrl.newBuilder()
                .build()
            val requestBuilder = requestOriginal.newBuilder().url(url)

            return@addInterceptor chain.proceed(requestBuilder.build())
        }

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    companion object {

        fun getPhotoList(retrofit: Retrofit): Observable<FlickrResponse> {
            val apiKey = "a2151c9414f1522ffd1fa7ffee126670"
            val a = retrofit.create(ApiService::class.java)

            val d = a.getPhoto("flickr.photos.getRecent",apiKey, "json", "1", "url_s", "1", null)
            return d
        }
    }

}

