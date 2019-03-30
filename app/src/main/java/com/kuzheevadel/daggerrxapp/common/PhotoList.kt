package com.kuzheevadel.daggerrxapp.common

import com.google.gson.annotations.SerializedName

data class PhotoList(@SerializedName("photo") var photoList: ArrayList<Photo>)