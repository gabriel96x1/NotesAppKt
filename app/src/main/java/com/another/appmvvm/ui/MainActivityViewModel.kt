package com.another.appmvvm.ui

import androidx.lifecycle.*
import com.another.appmvvm.ui.database.NotesDao
import com.another.appmvvm.ui.model.Note
import com.another.appmvvm.ui.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor( val repository: Repository) : ViewModel() {

    lateinit var currentNote :MutableLiveData<Note>
    var allNotes : LiveData<List<Note>>

    init {
        allNotes = repository.getAllNotes()
    }

    fun showAllNotes() : LiveData<List<Note>>{
        return allNotes
    }

    fun showSelectedNote() : LiveData<Note>{
        return currentNote
    }

    fun getAllNotes(){

        repository.getAllNotes()
    }

    suspend fun getOneNote(id : Int){
        repository.getOneNote(id)
    }

    suspend fun setNewNote(note : Note){
        repository.setNote(note)
    }

    fun toEditNote(){

    }

}