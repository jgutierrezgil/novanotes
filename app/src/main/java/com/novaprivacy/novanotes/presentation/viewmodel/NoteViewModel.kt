package com.novaprivacy.novanotes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novaprivacy.novanotes.domain.model.NoteModel
import com.novaprivacy.novanotes.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel // Lo usaremos en fases futuras, por ahora comentamos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject // Lo usaremos en fases futuras, por ahora comentamos

//@HiltViewModel // Anotación para Hilt (inyección de dependencias), la usaremos en fases futuras
class NoteViewModel( // Por ahora no usaremos @Inject constructor, inyección manual en Fase 1
    private val noteUseCases: NoteUseCases // Inyectaremos los casos de uso manualmente por ahora
) : ViewModel() {

    private val _notes = MutableStateFlow<List<NoteModel>>(emptyList())
    val notes: StateFlow<List<NoteModel>> = _notes.asStateFlow()

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            noteUseCases.getNotes().collectLatest { noteModels ->
                _notes.value = noteModels
            }
        }
    }

    // Funciones para interactuar con los casos de uso (CRUD, búsqueda, etc.) se añadirán en fases posteriores
}