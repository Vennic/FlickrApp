package com.kuzheevadel.daggerrxapp.interfaces


interface ListPresenterInterface: MvpPresenter<ListActivityInterface> {
    fun downloadPhotos()
}