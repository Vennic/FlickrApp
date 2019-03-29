package com.kuzheevadel.daggerrxapp.photolist

import android.content.Context
import com.kuzheevadel.daggerrxapp.common.Photo
import com.kuzheevadel.daggerrxapp.interfaces.ListActivityInterface
import com.kuzheevadel.daggerrxapp.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Module
class FlickrListModule(private val listActivity: ListActivityInterface) {

    @FlickrListScope
    @Provides
    fun providePresenter(networkService: NetworkService): FlickrListPresenter {
        return FlickrListPresenter(listActivity, networkService)
    }

    @FlickrListScope
    @Provides
    fun provideAdapter(list: List<Photo>, context: Context): RwAdapter {
        return RwAdapter(list, context)
    }

    @FlickrListScope
    @Provides
    fun provideList(): List<Photo> {
        return listOf()
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