package com.kuzheevadel.daggerrxapp.photolist

import android.content.Context
import com.kuzheevadel.daggerrxapp.common.Photo
import com.kuzheevadel.daggerrxapp.interfaces.ListActivityInterface
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import retrofit2.Retrofit
import javax.inject.Scope

@Module
class FlickrListModule(private val listActivity: ListActivityInterface) {

    @FlickrListScope
    @Provides
    fun providePresenter(retrofit: Retrofit): FlickrListPresenter {
        return FlickrListPresenter(listActivity, retrofit)
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