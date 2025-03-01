package com.novaprivacy.novanotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.novaprivacy.novanotes.data.db.DatabaseModule
import com.novaprivacy.novanotes.data.db.NoteDatabase
import com.novaprivacy.novanotes.data.encryption.EncryptionManagerImpl
import com.novaprivacy.novanotes.data.repository.NoteRepositoryImpl
import com.novaprivacy.novanotes.domain.DomainModule
import com.novaprivacy.novanotes.domain.use_case.NoteUseCases
import com.novaprivacy.novanotes.presentation.screen.NoteListScreen
import com.novaprivacy.novanotes.presentation.viewmodel.NoteViewModel
import com.novaprivacy.novanotes.ui.theme.NovaNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inyección de dependencias manual (¡Temporal para Fase 1!)
        val database: NoteDatabase = DatabaseModule.provideDatabase(applicationContext)
        val noteDao = DatabaseModule.provideNoteDao(database)
        val encryptionManager = EncryptionManagerImpl()
        val noteRepository = NoteRepositoryImpl(noteDao, encryptionManager)
        val noteUseCases = DomainModule.provideNoteUseCases(noteRepository)
        val noteViewModel = NoteViewModel(noteUseCases)


        setContent {
            NovaNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NoteListScreen(noteViewModel = noteViewModel) // Mostrar NoteListScreen y pasar el ViewModel
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NovaNotesTheme {
        Greeting("Android")
    }
}