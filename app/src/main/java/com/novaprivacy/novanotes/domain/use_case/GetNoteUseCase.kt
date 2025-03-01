package com.novaprivacy.novanotes.domain.use_case

import com.novaprivacy.novanotes.data.repository.NoteRepository
import com.novaprivacy.novanotes.domain.model.NoteModel // Suponemos que aún no existe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(id: Long): Flow<NoteModel?> { // Permite null si no se encuentra la nota
        return repository.getNoteById(id).map { noteEntity ->
            noteEntity?.let { NoteModel.fromEntity(it) } // Mapear de entidad a modelo (o null si entity es null)
        }
    }
}