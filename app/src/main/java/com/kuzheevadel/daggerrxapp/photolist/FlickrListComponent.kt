package com.kuzheevadel.daggerrxapp.photolist

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Module
class FlickrListModule {

    @FlicrListScope
    @Provides
    fun providePresenter(): Presenter {
        return Presenter()
    }

    @FlicrListScope
    @Provides
    fun provideAdapter(list: List<Int>, context: Context): RwAdapter {
        return RwAdapter(list, context)
    }

    @FlicrListScope
    @Provides
    fun provideList(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
}

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class FlicrListScope{
}

@FlicrListScope
@Subcomponent(modules = [FlickrListModule::class])
interface FlicrListComponent {
    fun inject(flickrListActivity: FlickrListActivity)
}