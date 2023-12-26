package com.example.aplikasidatasiswa.ui.kontak.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasidatasiswa.model.Kontak
import com.example.aplikasidatasiswa.repository.KontakRepository
import kotlinx.coroutines.launch

class InsertViewModel(private val kontakRepository: KontakRepository) : ViewModel(){

}

data class InsertUiState(
    val inserUiEvent: InsertUiEvent = InsertUiEvent(),
)

data class InsertUiEvent(
    val id: Int = 0,
    val nama: String = "",
    val email: String = "",
    val nohp: String = "",
)

