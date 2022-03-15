package com.another.appmvvm.ui

import androidx.lifecycle.*
import com.another.appmvvm.ui.model.Note
import com.another.appmvvm.ui.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {


    lateinit var currentNote :MutableLiveData<Note>
    lateinit var allNotes : MutableLiveData<List<Note>>

    fun showAllNotes() : LiveData<List<Note>>{
        return allNotes
    }

    fun showSelectedNote() : LiveData<Note>{
        return currentNote
    }

    fun getAllNotes(){
        repository.getAllNotes()
    }

    fun getOneNote(id : Int){
        repository.getOneNote(id)
    }

    fun setNewNote(note : Note){
        repository.setNote(note)
    }

    fun toEditNote(){

    }


}