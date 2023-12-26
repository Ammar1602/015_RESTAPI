package com.example.aplikasidatasiswa.ui.Home.ViewModel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.IdRes
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasidatasiswa.model.Kontak
import com.example.aplikasidatasiswa.repository.KontakRepository
import kotlinx.coroutines.launch
import okio.IOException

sealed class KontakUIState {
    data class Success(val kontak: List<Kontak>): KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}

class HomeViewModel (private val kontakRepository: KontakRepository) : ViewModel(){
    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    init {
        getKontak()
    }



    fun getKontak(){
        viewModelScope.launch {
            kontakUIState = KontakUIState.Loading
            kontakUIState = try {
                KontakUIState.Success(kontakRepository.getKontak())
            } catch (e: IOException){
                KontakUIState.Error
            } catch (e: retrofit2.HttpException){
                KontakUIState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun deleteKontak(id: Int){
        viewModelScope.launch{
            try {
                kontakRepository.deleteKontak(id)
            }catch (e: IOException){
                KontakUIState.Error
            }catch (e: HttpException){
                KontakUIState.Error
            }
        }
    }
}