package com.kuzheevadel.daggerrxapp.interfaces

interface MvpView

interface MvpPresenter<V: MvpView> {
    fun attachView(view: V)
    fun viewIsReady()
    fun detachView()
    fun destroy()
}

abstract class PresenterBase<T: MvpView> : MvpPresenter<T> {

    var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun viewIsReady() {
    }

    protected fun isViewAttached(): Boolean {
        return view != null
    }

    override fun detachView() {
        view = null
    }

    override fun destroy() {

    }
}
