package com.example.unsplash_api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo_Url(
    @SerializedName("full") var full: String = "",
    @SerializedName("regular") var regular: String = ""
) : Parcelable