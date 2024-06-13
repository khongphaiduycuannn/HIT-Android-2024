package com.example.buoi13.data.source.remote

import kotlinx.coroutines.delay
import java.util.Date

class NetworkNoteDataSource {

    private val noteList = mutableListOf (
        NetworkNote(
            id = null,
            title = "1",
            createdOn = Date(),
            content = "Mot"
        ),
        NetworkNote(
            id = null,
            title = "2",
            createdOn = Date(),
            content = "Mot"
        ),
        NetworkNote(
            id = null,
            title = "3",
            createdOn = Date(),
            content = "Mot"
        )
    )

    suspend fun getData(): List<NetworkNote> {
        delay(2500)
        return noteList
    }

    suspend fun create(networkNote: NetworkNote) {
        delay(2500)
        noteList.add(networkNote)
    }
}