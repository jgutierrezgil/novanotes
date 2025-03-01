package com.novaprivacy.novanotes.domain.use_case

import com.novaprivacy.novanotes.data.repository.NoteRepository
import com.novaprivacy.novanotes.domain.model.NoteModel // Suponemos que aún no existe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(query: String): Flow<List<NoteModel>> {
        return repository.searchNotes(query).map { notes ->
            notes.map { note -> NoteModel.fromEntity(note) } // Mapear de entidad a modelo
        }
    }
}