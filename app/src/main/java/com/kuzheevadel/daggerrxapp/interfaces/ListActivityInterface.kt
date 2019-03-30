package com.kuzheevadel.daggerrxapp.interfaces

import com.kuzheevadel.daggerrxapp.photolist.RwAdapter

interface ListActivityInterface: MvpView {
    fun getAdapter(): RwAdapter
    fun showProgressBar()
    fun hideProgressBar()
}