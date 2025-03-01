package com.novaprivacy.novanotes.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNote: AddNoteUseCase,
    val getNote: GetNoteUseCase,
    val updateNote: UpdateNoteUseCase,
    val searchNotes: SearchNotesUseCase
)