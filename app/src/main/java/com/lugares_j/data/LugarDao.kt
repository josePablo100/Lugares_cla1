package com.lugares_j.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugares_j.model.Lugar

interface LugarDao {



    interface LugarDao {
        //las funciones de bajo nivel para hacer un crud
        //create read update delete

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addLugar(Lugar: Lugar)

        @Update(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addLugar(Lugar: Lugar)

        @Delete
        suspend fun addLugar(Lugar: Lugar)

        @Query("SELECT * FROM LUGAR")
        fun fetLugares() : LiveData<List<Lugar>>
    }
}