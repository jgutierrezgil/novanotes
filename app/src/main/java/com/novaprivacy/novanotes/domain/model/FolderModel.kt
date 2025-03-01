package com.novaprivacy.novanotes.domain.model

import com.novaprivacy.novanotes.data.db.entity.Folder
import java.util.Date

data class FolderModel(
    val id: Long = 0,
    val name: String,
    val createdAt: Date = Date()
)


// Funciones de extensión para mapear entre FolderModel y Folder (entidad)
fun FolderModel.toEntity(): Folder {
    return Folder(
        id = this.id,
        name = this.name,
        createdAt = this.createdAt
    )
}

fun FolderModel.Companion.fromEntity(folder: Folder): FolderModel {
    return FolderModel(
        id = folder.id,
        name = folder.name,
        createdAt = folder.createdAt
    )
}