package com.novaprivacy.novanotes.domain

import com.novaprivacy.novanotes.data.repository.FolderRepository
import com.novaprivacy.novanotes.data.repository.NoteRepository
import com.novaprivacy.novanotes.domain.use_case.AddFolderUseCase
import com.novaprivacy.novanotes.domain.use_case.AddNoteUseCase
import com.novaprivacy.novanotes.domain.use_case.DeleteFolderUseCase
import com.novaprivacy.novanotes.domain.use_case.DeleteNoteUseCase
import com.novaprivacy.novanotes.domain.use_case.FolderUseCases
import com.novaprivacy.novanotes.domain.use_case.GetFolderUseCase
import com.novaprivacy.novanotes.domain.use_case.GetFoldersUseCase
import com.novaprivacy.novanotes.domain.use_case.GetNoteUseCase
import com.novaprivacy.novanotes.domain.use_case.GetNotesUseCase
import com.novaprivacy.novanotes.domain.use_case.NoteUseCases
import com.novaprivacy.novanotes.domain.use_case.SearchNotesUseCase
import com.novaprivacy.novanotes.domain.use_case.UpdateFolderUseCase
import com.novaprivacy.novanotes.domain.use_case.UpdateNoteUseCase

object DomainModule {

    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = provideGetNotesUseCase(repository),
            deleteNote = provideDeleteNoteUseCase(repository),
            addNote = provideAddNoteUseCase(repository),
            getNote = provideGetNoteUseCase(repository),
            updateNote = provideUpdateNoteUseCase(repository),
            searchNotes = provideSearchNotesUseCase(repository)
        )
    }

    fun provideFolderUseCases(repository: FolderRepository): FolderUseCases {
        return FolderUseCases(
            getFolders = provideGetFoldersUseCase(repository),
            deleteFolder = provideDeleteFolderUseCase(repository),
            addFolder = provideAddFolderUseCase(repository),
            getFolder = provideGetFolderUseCase(repository),
            updateFolder = provideUpdateFolderUseCase(repository)
        )
    }


    fun provideGetNotesUseCase(repository: NoteRepository): GetNotesUseCase {
        return GetNotesUseCase(repository)
    }

    fun provideDeleteNoteUseCase(repository: NoteRepository): DeleteNoteUseCase {
        return DeleteNoteUseCase(repository)
    }

    fun provideAddNoteUseCase(repository: NoteRepository): AddNoteUseCase {
        return AddNoteUseCase(repository)
    }

    fun provideGetNoteUseCase(repository: NoteRepository): GetNoteUseCase {
        return GetNoteUseCase(repository)
    }

    fun provideUpdateNoteUseCase(repository: NoteRepository): UpdateNoteUseCase {
        return UpdateNoteUseCase(repository)
    }

    fun provideSearchNotesUseCase(repository: NoteRepository): SearchNotesUseCase {
        return SearchNotesUseCase(repository)
    }


    fun provideGetFoldersUseCase(repository: FolderRepository): GetFoldersUseCase {
        return GetFoldersUseCase(repository)
    }

    fun provideDeleteFolderUseCase(repository: FolderRepository): DeleteFolderUseCase {
        return DeleteFolderUseCase(repository)
    }

    fun provideAddFolderUseCase(repository: FolderRepository): AddFolderUseCase {
        return AddFolderUseCase(repository)
    }

    fun provideGetFolderUseCase(repository: FolderRepository): GetFolderUseCase {
        return GetFolderUseCase(repository)
    }

    fun provideUpdateFolderUseCase(repository: FolderRepository): UpdateFolderUseCase {
        return UpdateFolderUseCase(repository)
    }
}