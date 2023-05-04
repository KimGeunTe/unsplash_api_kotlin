package com.example.unsplash_api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sponsorship(@SerializedName("tagline") var tagline: String = "") : Parcelable
