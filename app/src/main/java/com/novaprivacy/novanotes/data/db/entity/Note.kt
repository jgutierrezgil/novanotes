package com.novaprivacy.novanotes.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val folderId: Long? = null // Permite que una nota no esté en una carpeta inicialmente
)