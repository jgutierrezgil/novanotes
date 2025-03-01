package com.novaprivacy.novanotes.domain.use_case

import com.novaprivacy.novanotes.data.repository.NoteRepository
import com.novaprivacy.novanotes.domain.model.NoteModel // Suponemos que aún no existe

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: NoteModel) {
        repository.insertNote(note.toEntity()) // Mapear de modelo a entidad antes de pasar al repositorio
    }
}