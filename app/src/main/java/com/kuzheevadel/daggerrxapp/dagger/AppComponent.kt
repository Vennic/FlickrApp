package com.kuzheevadel.daggerrxapp.dagger

import android.content.Context
import com.kuzheevadel.daggerrxapp.network.NetworkModule
import com.kuzheevadel.daggerrxapp.photolist.FlickrListModule
import com.kuzheevadel.daggerrxapp.photolist.FlicrListComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun getFlickrListComponent(flickrListModule: FlickrListModule): FlicrListComponent
}