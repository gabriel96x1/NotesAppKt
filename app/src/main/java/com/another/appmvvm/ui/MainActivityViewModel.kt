package com.another.appmvvm.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.another.appmvvm.ui.model.Note
import com.another.appmvvm.ui.repository.Repository

class MainActivityViewModel(
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

    fun getOneNote(id : Long){
        repository.getOneNote(id)
    }

    fun setNewNote(note : LiveData<Note>){
        repository.setNote(note)
    }

    fun toEditNote(){

    }

}