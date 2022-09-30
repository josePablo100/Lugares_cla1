package com.lugares_j.repositorio

import androidx.lifecycle.LiveData
import com.lugares_j.data.LugarDao
import com.lugares_j.model.Lugar


class LugarRepository(private val lugarDao: LugarDao) {


    suspend fun saveLugar(lugar: Lugar) {
        if (lugar.id == null) { //Es un lugar nuevo
            lugarDao.addLugar(lugar)
        } else { //es un lugar ya registrado
            lugarDao.updateLugar(lugar)

        }
    }
suspend fun deleteLugar(lugar: Lugar){
if (lugar.id!=null) {
    lugarDao.deleteLugar(lugar)
}

}

    val getLugares : LiveData<List<Lugar>> = lugarDao.getLugares()
}