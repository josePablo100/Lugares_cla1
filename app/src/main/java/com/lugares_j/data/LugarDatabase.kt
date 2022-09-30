package com.lugares_j.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lugares_j.model.Lugar

@Database(entities =[Lugar::class], version = 1, exportSchema = false)
abstract class LugarDatabase: RoomDatabase() {

    abstract fun LugarDao() : LugarDao

    companion object {
        @Volatile
        private var INSTANCE: LugarDatabase? = null

        fun getDatabase(context: Context) : LugarDatabase {
            val local = INSTANCE
            if (local != null) {
                return local
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LugarDatabase::class.java,
                    "Lugar_database"

                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }



}