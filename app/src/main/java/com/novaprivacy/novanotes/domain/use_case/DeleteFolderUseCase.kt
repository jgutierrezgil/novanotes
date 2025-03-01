package com.novaprivacy.novanotes.domain.use_case

import com.novaprivacy.novanotes.data.repository.FolderRepository
import com.novaprivacy.novanotes.domain.model.FolderModel // Suponemos que aún no existe

class DeleteFolderUseCase(
    private val repository: FolderRepository
) {
    suspend operator fun invoke(folder: FolderModel) {
        repository.deleteFolder(folder.toEntity()) // Mapear de modelo a entidad antes de pasar al repositorio
    }
}