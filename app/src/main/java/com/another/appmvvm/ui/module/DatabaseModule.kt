package com.another.appmvvm.ui.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.another.appmvvm.ui.database.AppDatabase
import com.another.appmvvm.ui.database.NotesDao
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "notes.db"
        ).build()
    }

    @Provides
    fun provideNotesDao(appDatabase: AppDatabase): NotesDao {
        return appDatabase.notesDao()
    }


}
