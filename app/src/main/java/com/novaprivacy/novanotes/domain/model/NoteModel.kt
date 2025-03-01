package com.novaprivacy.novanotes.domain.model

import com.example.novanotes.data.db.entity.Note
import java.util.Date

data class NoteModel(
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val folderId: Long? = null
)

// Funciones de extensión para mapear entre NoteModel y Note (entidad)
fun NoteModel.toEntity(): Note {
    return Note(
        id = this.id,
        title = this.title,
        content = this.content,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        folderId = this.folderId
    )
}

fun NoteModel.Companion.fromEntity(note: Note): NoteModel {
    return NoteModel(
        id = note.id,
        title = note.title,
        content = note.content,
        createdAt = note.createdAt,
        updatedAt = note.updatedAt,
        folderId = note.folderId
    )
}