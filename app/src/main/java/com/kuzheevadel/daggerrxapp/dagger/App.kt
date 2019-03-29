package com.kuzheevadel.daggerrxapp.dagger

import android.app.Application
import com.kuzheevadel.daggerrxapp.interfaces.ListActivityInterface
import com.kuzheevadel.daggerrxapp.photolist.FlickrListModule
import com.kuzheevadel.daggerrxapp.photolist.FlicrListComponent

class App: Application() {

    companion object {
        lateinit var instance: App
    }

    private lateinit var appComponent: AppComponent
    private var flicrListComponent: FlicrListComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }

    fun createFlickrListComponent(listActivity: ListActivityInterface): FlicrListComponent? {
        flicrListComponent = appComponent.getFlickrListComponent(FlickrListModule(listActivity))
        return flicrListComponent
    }

    fun releaseFlickrListComponent() {
        flicrListComponent = null
    }

    fun getAppComponent() = appComponent
}