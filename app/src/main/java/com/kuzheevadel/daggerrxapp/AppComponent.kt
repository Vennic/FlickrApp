package com.kuzheevadel.daggerrxapp

import android.content.Context
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
@Component(modules = [AppModule::class])
interface AppComponent {
    fun createFlickrListComponent(): FlicrListComponent
}