package com.novaprivacy.novanotes.domain.use_case

import com.novaprivacy.novanotes.data.repository.FolderRepository
import com.novaprivacy.novanotes.domain.model.FolderModel // Suponemos que aún no existe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFolderUseCase(
    private val repository: FolderRepository
) {
    operator fun invoke(id: Long): Flow<FolderModel?> { // Permite null si no se encuentra la carpeta
        return repository.getFolderById(id).map { folderEntity ->
            folderEntity?.let { FolderModel.fromEntity(it) } // Mapear de entidad a modelo (o null si entity es null)
        }
    }
}