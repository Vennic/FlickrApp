package com.kuzheevadel.daggerrxapp.interfaces

import com.kuzheevadel.daggerrxapp.common.Photo

interface ListActivityInterface {
    fun updateAdapter(photoList: List<Photo>)
}