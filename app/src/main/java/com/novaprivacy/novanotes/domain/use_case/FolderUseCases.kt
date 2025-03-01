package com.novaprivacy.novanotes.domain.use_case

data class FolderUseCases(
    val getFolders: GetFoldersUseCase,
    val deleteFolder: DeleteFolderUseCase,
    val addFolder: AddFolderUseCase,
    val getFolder: GetFolderUseCase,
    val updateFolder: UpdateFolderUseCase
)