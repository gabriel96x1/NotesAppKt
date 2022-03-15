/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.another.appmvvm.ui.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.another.appmvvm.ui.database.AppDatabase
import com.another.appmvvm.ui.database.NotesDao
import com.another.appmvvm.ui.model.Note

class Repository constructor(
  application: Application,
){

  private val db : AppDatabase = AppDatabase.getAppDataBase(application)!!
  private val notesDao = db.notesDao()


  fun setNote(note : LiveData<Note>) = notesDao.insertNote(note)

  fun getAllNotes() = notesDao.getNotesList()

  fun getOneNote(id: Long) = notesDao.getNote(id)

}
