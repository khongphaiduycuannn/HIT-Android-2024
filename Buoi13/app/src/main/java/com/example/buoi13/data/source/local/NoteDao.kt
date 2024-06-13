package com.example.buoi13.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAll(): LiveData<List<LocalNote>>

    @Upsert
    suspend fun upsert(task: LocalNote)

    @Upsert
    suspend fun upsertAll(notes: List<LocalNote>)

    @Query("DELETE FROM note")
    suspend fun deleteAll()
}