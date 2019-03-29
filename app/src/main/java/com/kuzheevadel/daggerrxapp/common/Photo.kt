package com.kuzheevadel.daggerrxapp.common

import com.google.gson.annotations.SerializedName

data class Photo(@SerializedName("title") var title: String,
                @SerializedName("id") var id: String,
                @SerializedName("url_s") var url_s: String)