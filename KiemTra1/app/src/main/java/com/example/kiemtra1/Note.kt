package com.example.kiemtra1

import java.util.Date

data class Note(
    val title: String,
    val content: String,
    val createdAt: Date,
    var isFavourite: Boolean
)
