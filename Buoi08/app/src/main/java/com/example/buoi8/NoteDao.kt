package com.example.buoi8

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAllNote(): List<Note>

    @Insert
    fun addNote(note: Note)
}