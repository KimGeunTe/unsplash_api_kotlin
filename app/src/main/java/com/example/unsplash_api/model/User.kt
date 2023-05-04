package com.example.unsplash_api.model

import android.os.Parcelable
import com.example.unsplash_api.model.ProfileImage
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("id") var id: String = "",
    @SerializedName("username") var username: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("profile_image") var profileImage: ProfileImage = ProfileImage(),
    @SerializedName("total_photos") var TotalPhotos: String = "",
    @SerializedName("total_collections") var collection: String = ""
) : Parcelable
