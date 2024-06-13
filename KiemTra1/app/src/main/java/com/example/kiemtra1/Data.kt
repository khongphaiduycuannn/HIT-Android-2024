package com.example.kiemtra1

import java.util.Date

object Data {
    val notesList = mutableListOf(
        Note(
            "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna",
            Date(2024, 16, 4, 12, 3),
            true
        ),
        Note(
            "Pellentesque habitant morbi tristique",
            "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede",
            Date(2024, 17, 4, 22, 4),
            false
        ),
        Note(
            "Suspendisse dui purus",
            "Suspendisse dui purus, scelerisque at, vulputate vitae, pretium mattis, nunc. Mauris eget neque at sem venenatis eleifend.",
            Date(2024, 16, 4, 12, 3),
            false
        ),
    )
}