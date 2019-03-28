package com.kuzheevadel.daggerrxapp.photolist

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Module
class FlickrListModule {

    @FlickrListScope
    @Provides
    fun providePresenter(): FlickrListPresenter {
        return FlickrListPresenter()
    }

    @FlickrListScope
    @Provides
    fun provideAdapter(list: List<Int>, context: Context): RwAdapter {
        return RwAdapter(list, context)
    }

    @FlickrListScope
    @Provides
    fun provideList(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
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