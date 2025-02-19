package com.novaprivacy.novanotes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.novaprivacy.novanotes.data.db.entity.Folder
import com.novaprivacy.novanotes.data.db.entity.Note

@Database(entities = [Note::class, Folder::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class) // Converter para Date
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract fun folderDao(): FolderDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database" // Nombre del archivo de la base de datos
                )
                    .openHelperFactory(net.zetetic.database.sqlcipher.SQLiteOpenHelperFactory("your_db_password".toByteArray())) // **¡IMPORTANTE! Reemplazar con una forma segura de gestionar la contraseña**
                    .fallbackToDestructiveMigration() // Política de migración destructiva para simplificar en desarrollo inicial
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}