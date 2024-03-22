package com.example.buoi3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username: String,
    val gender: Boolean
) : Parcelable