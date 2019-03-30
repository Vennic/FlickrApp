package com.kuzheevadel.daggerrxapp.photolist

import android.annotation.SuppressLint
import android.util.Log
import com.kuzheevadel.daggerrxapp.Constants
import com.kuzheevadel.daggerrxapp.common.Photo
import com.kuzheevadel.daggerrxapp.interfaces.ListActivityInterface
import com.kuzheevadel.daggerrxapp.interfaces.ListPresenterInterface
import com.kuzheevadel.daggerrxapp.interfaces.PresenterBase
import com.kuzheevadel.daggerrxapp.network.NetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class FlickrListPresenter(private val networkService: NetworkService): PresenterBase<ListActivityInterface>(), ListPresenterInterface {

    @SuppressLint("CheckResult")
    override fun downloadPhotos() {
        view?.showProgressBar()

        networkService.getPhotoList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val list: ArrayList<Photo> = it.photoList.photoList
                view?.getAdapter()?.updateAdapter(list)
                view?.hideProgressBar()
            }
    }
}