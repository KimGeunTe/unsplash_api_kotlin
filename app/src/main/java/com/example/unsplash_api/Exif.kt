package com.example.unsplash_api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exif(
    @SerializedName("make") var make: String = "",
    @SerializedName("model") var model: String = "",
    @SerializedName("exposure_time") var exposure: String = "",
    @SerializedName("aperture") var aperture: String = "",
    @SerializedName("focal_length") var focal: String = "",
    @SerializedName("iso") var iso: String = ""
) : Parcelable
