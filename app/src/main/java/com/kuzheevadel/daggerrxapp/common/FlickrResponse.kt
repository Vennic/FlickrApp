package com.kuzheevadel.daggerrxapp.common

import com.google.gson.annotations.SerializedName

data class FlickrResponse(@SerializedName("photos") var photoList: PhotoList)