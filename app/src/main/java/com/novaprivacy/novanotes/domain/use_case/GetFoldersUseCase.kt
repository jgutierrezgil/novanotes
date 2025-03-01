package com.novaprivacy.novanotes.domain.use_case

import com.novaprivacy.novanotes.data.repository.FolderRepository
import com.novaprivacy.novanotes.domain.model.FolderModel // Suponemos que aún no existe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFoldersUseCase(
    private val repository: FolderRepository
) {
    operator fun invoke(): Flow<List<FolderModel>> {
        return repository.getAllFolders().map { folders ->
            folders.map { folder -> FolderModel.fromEntity(folder) } // Mapear de entidad a modelo
        }
    }
}