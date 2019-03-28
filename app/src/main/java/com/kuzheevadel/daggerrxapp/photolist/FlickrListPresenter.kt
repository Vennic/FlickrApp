package com.kuzheevadel.daggerrxapp.photolist

import android.util.Log
import com.kuzheevadel.daggerrxapp.Constants

class FlickrListPresenter(private val activity: FlickrListActivity) {

    init {
        Log.i(Constants.FLICKR_LIST_TAG, activity.toString())
    }

}