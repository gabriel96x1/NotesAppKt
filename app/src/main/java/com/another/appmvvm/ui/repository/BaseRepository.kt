package com.another.appmvvm.ui.repository

import androidx.lifecycle.LiveData
import com.another.appmvvm.ui.model.Note

interface BaseRepository {

    suspend fun setNote(note : Note)

    fun getAllNotes(): LiveData<List<Note>>

    suspend fun getOneNote(id: Int): LiveData<Note>

}