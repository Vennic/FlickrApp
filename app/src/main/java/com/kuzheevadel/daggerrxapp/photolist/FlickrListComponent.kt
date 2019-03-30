package com.kuzheevadel.daggerrxapp.photolist

import android.content.Context
import com.kuzheevadel.daggerrxapp.common.Photo
import com.kuzheevadel.daggerrxapp.interfaces.ListActivityInterface
import com.kuzheevadel.daggerrxapp.interfaces.ListPresenterInterface
import com.kuzheevadel.daggerrxapp.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Module
class FlickrListModule {

    @FlickrListScope
    @Provides
    fun providePresenter(networkService: NetworkService): ListPresenterInterface {
        return FlickrListPresenter(networkService)
    }

    @FlickrListScope
    @Provides
    fun provideAdapter(list: ArrayList<Photo>, context: Context): RwAdapter {
        return RwAdapter(list, context)
    }

    @FlickrListScope
    @Provides
    fun provideList(): ArrayList<Photo> {
        return arrayListOf()
    }
}

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class FlickrListScope

@FlickrListScope
@Subcomponent(modules = [FlickrListModule::class])
interface FlicrListComponent {
    fun inject(flickrListActivity: FlickrListActivity)
}