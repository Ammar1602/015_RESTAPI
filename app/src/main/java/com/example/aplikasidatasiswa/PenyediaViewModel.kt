package com.example.aplikasidatasiswa

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.aplikasidatasiswa.ui.Home.ViewModel.HomeViewModel
import com.example.aplikasidatasiswa.ui.kontak.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiKontak().container.KontakRepository)
        }

        initializer {
            InsertViewModel(aplikasiKontak().container.KontakRepository)
        }
    }
}

fun CreationExtras.aplikasiKontak(): KontakApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakApplication)