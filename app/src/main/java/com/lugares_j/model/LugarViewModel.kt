package com.lugares_j.model

import android.app.Application
import androidx.lifecycle.*
import com.lugares_j.data.LugarDatabase
import com.lugares_j.repositorio.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LugarViewModel(application: Application) : AndroidViewModel(application) {

    private val lugarRepository: LugarRepository
    val getLugares: LiveData<List<Lugar>>

    init {
        val lugarDao = LugarDatabase.getDatabase(application).lugarDao()
        lugarRepository = LugarRepository(lugarDao)
        getLugares = lugarRepository.getLugares
    }

    fun saveLugar(lugar: Lugar) {
        viewModelScope.launch(Dispatchers.IO) {
            LugarRepository.saveLugar(lugar)  }
    }




fun deleteLugar(lugar: Lugar) {
    viewModelScope.launch(Dispatchers.IO) {
        LugarRepository.deleteLugar(lugar)
    }

}