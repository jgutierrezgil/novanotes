package com.novaprivacy.novanotes.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novaprivacy.novanotes.presentation.viewmodel.NoteViewModel
import com.novaprivacy.novanotes.ui.theme.NovaNotesTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(
    noteViewModel: NoteViewModel // Recibe el ViewModel como parámetro
) {
    val notes by noteViewModel.notes.collectAsState() // Observa el StateFlow de notas del ViewModel

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NovaNotes") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO: Navegar a pantalla de creación de nota*/ }) {
                Icon(Icons.Filled.Add, "Add note")
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Mis Notas",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(notes) { note ->
                        NoteItem(note = note) // Composable para mostrar cada nota individualmente
                    }
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: com.novaprivacy.novanotes.domain.model.NoteModel) { // Usar el NoteModel del dominio
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 4.dp),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 1.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = note.title, // Mostrar el título de la nota
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = note.content, // Mostrar el contenido de la nota (inicialmente, primeras líneas o resumen)
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2 // Limitar a 2 líneas para el listado
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NoteListScreenPreview() {
    NovaNotesTheme {
        // Para la preview, necesitaremos un NoteViewModel de prueba o Mock
        // Por ahora, pasamos null o un ViewModel vacío (¡NO es ideal para previews complejas!)
        // En fases posteriores, implementaremos ViewModels de prueba adecuados para previews y tests
        NoteListScreen(noteViewModel = NoteViewModel(noteUseCases = TODO())) // ¡Temporal -  Reemplazar con un ViewModel de prueba!
    }
}