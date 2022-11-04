package com.lugares_j.model

import android.app.Application
import androidx.lifecycle.*
import com.lugares_j.data.LugarDao
import com.lugares_j.repositorio.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LugarViewModel(application: Application) : AndroidViewModel(application) {

    private val lugarRepository: LugarRepository = LugarRepository(LugarDao())
    val getLugares: MutableLiveData<List<Lugar>>




    fun saveLugar(lugar: Lugar) {
        viewModelScope.launch(Dispatchers.IO) {
            LugarRepository.saveLugar(lugar)  }
    }




fun deleteLugar(lugar: Lugar) {
    viewModelScope.launch(Dispatchers.IO) {
        LugarRepository.deleteLugar(lugar)
    }
}
