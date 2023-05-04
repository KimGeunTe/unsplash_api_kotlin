package com.example.unsplash_api.model

import android.os.Parcelable
import com.example.unsplash_api.Exif
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// https://unsplash.com/documentation#list-photos
@Parcelize
data class PhotoData(
    @SerializedName("id") var id: String = "",
    @SerializedName("width") var width: String = "",
    @SerializedName("height") var height: String = "",
    @SerializedName("color") var color: String = "",
    @SerializedName("alt_description") var description: String = "",
    @SerializedName("urls") var url: Photo_Url = Photo_Url(),
    @SerializedName("user") var user: User = User(),
    @SerializedName("likes") var likes: String = "",
//    @SerializedName("sponsorship") var sponsorship: Sponsorship = Sponsorship(),
    @SerializedName("exif") var exif: Exif = Exif()
) : Parcelable
