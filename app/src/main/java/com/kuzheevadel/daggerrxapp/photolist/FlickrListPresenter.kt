package com.kuzheevadel.daggerrxapp.photolist

import android.util.Log
import com.kuzheevadel.daggerrxapp.Constants
import com.kuzheevadel.daggerrxapp.common.Photo
import com.kuzheevadel.daggerrxapp.interfaces.ListActivityInterface
import com.kuzheevadel.daggerrxapp.interfaces.ListPresenterInterface
import com.kuzheevadel.daggerrxapp.network.NetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class FlickrListPresenter(private val listActivity: ListActivityInterface,
                          private val networkService: NetworkService): ListPresenterInterface {

    override fun downloadPhotos() {
        networkService.getPhotoList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val list: List<Photo> = it.photoList.photoList
                listActivity.updateAdapter(list)
            }
    }

    init {
        Log.i(Constants.FLICKR_LIST_TAG, listActivity.toString())
    }

}