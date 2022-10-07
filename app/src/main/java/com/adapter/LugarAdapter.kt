package com.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lugares_cla1.databinding.FragmentAddLugarBinding
import com.example.lugares_cla1.databinding.LugarFilaBinding


class LugarAdapter :RecyclerView.Adapter<LugarAdapter.LugarViewHolder>(){
inner class LugarViewHolder(private val itemBinding: LugarFilaBinding)
    : RecyclerView.ViewHolder(itemBinding.root){
        fun dibuja(ligar: Lugar) {
            itemBinding.tvNombre.text = lugar.nombre
            itemBinding.tvCorreo.text = lugar.correo
            itemBinding.tvTelefono.text = lugar.telefono

        }
    }

    private var listaLugares = emptyList<Lugar>()

    //esta funcion crea cajitas para cada lugar en memoria
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
       val itemBinding = LugarFilaBinding.inflate(LayoutInflater.from(parent.context),
           parent,
           false)
        return LugarViewHolder(itemBinding)
    }

    //esta funcion toma un lugar para cada lugar en memoria
    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.dibuja(lugar)
    }

    // esta fincion vuelve la cnatidad de elementos a dibujar
    override fun getItemCount(): Int {

        return listaLugares.size
    }

    fun setListaLugares(lugares: List<Lugar>) {
        this.listaLugares = lugares
        notifyDataSetChanged()
    }
}