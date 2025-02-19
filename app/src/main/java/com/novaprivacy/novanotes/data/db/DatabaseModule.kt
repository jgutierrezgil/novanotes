package com.novaprivacy.novanotes.data.db

import android.content.Context

object DatabaseModule {
    fun provideDatabase(context: Context): NoteDatabase {
        return NoteDatabase.getDatabase(context)
    }

    fun provideNoteDao(database: NoteDatabase): NoteDao {
        return database.noteDao()
    }

    fun provideFolderDao(database: NoteDatabase): FolderDao {
        return database.folderDao()
    }
}