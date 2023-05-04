package com.example.unsplash_api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileImage(
    @SerializedName("small") var small: String = "",
    @SerializedName("medium") var medium: String = "",
    @SerializedName("large") var large: String = ""
) : Parcelable
