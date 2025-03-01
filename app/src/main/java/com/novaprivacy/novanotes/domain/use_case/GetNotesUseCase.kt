package com.novaprivacy.novanotes.domain.use_case

import com.novaprivacy.novanotes.data.repository.NoteRepository
import com.novaprivacy.novanotes.domain.model.NoteModel // Suponemos que aún no existe, lo crearemos en el paso 5
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<NoteModel>> {
        return repository.getAllNotes().map { notes ->
            notes.map { note -> NoteModel.fromEntity(note) } // Mapear de entidad a modelo
        }
    }
}