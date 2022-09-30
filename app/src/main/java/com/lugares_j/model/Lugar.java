package com.lugares_j.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import kotlinx.parcelize.Parcelize;

public class Lugar<data> {

    import android.os.Parcelable
    import androidx.room.*
    import kotlinx.parcelize.Parcelize

    @Parcelize
    @Entity(tablename="lugar")
    data class Lugar (
            @PrimaryKey(autoGenerate = true)
            val id:Int,
            @ColumInfo(name="correo")
            val correo: String? ,
            @ColumInfo(name="telefono")
            val telefono: String? ,
            @ColumInfo(name="web")
            val web: String? ,
            @ColumInfo(name="latitud")
            val latitud: Double? ,
            @ColumInfo(name="altura")
            val altura: Double? ,
            @ColumInfo(name="ruta_audio")
            val ruta_audio: String? ,
            @ColumInfo(name="ruta_imagen")
            val rutaImagen: String? ,
            )
    )
}
