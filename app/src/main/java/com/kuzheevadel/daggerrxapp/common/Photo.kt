package com.kuzheevadel.daggerrxapp.common

import com.google.gson.annotations.SerializedName

data class Photo(@SerializedName("title") var title: String,
                @SerializedName("id") var id: String,
                @SerializedName("url_c") var url_c: String)