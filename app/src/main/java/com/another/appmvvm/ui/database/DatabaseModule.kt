package com.another.appmvvm.ui.database

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getAppDataBase(context)!!
    }

    @Provides
    fun provideNotesDao(appDatabase: AppDatabase): NotesDao {
        return appDatabase.notesDao()
    }


}
