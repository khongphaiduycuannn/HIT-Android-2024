package com.example.buoi13.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.buoi13.data.source.local.NoteDao
import com.example.buoi13.data.source.local.toListNote
import com.example.buoi13.data.source.local.toLocalNote
import com.example.buoi13.data.source.remote.NetworkNoteDataSource
import com.example.buoi13.data.source.remote.toNetworkNote
import com.example.buoi13.data.source.remote.toNote

class NoteRepository(
    private val noteDao: NoteDao,
    private val networkNoteDataSource: NetworkNoteDataSource
) {

    fun getAll(): LiveData<List<Note>> {
        return noteDao.getAll().map { localNotes ->
            localNotes.toListNote()
        }
    }

    suspend fun refresh() {
        val networkData = networkNoteDataSource.getData().map { networkNotes ->
            networkNotes.toNote()
        }
        noteDao.deleteAll()
        noteDao.upsertAll(networkData.map { note ->
            note.toLocalNote()
        })
    }

    suspend fun create(note: Note) {
        noteDao.upsert(note.toLocalNote())
        networkNoteDataSource.create(note.toNetworkNote())
    }
}