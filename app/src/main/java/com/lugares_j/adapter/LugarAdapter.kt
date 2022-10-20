package com.lugares_j.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lugares_cla1.databinding.FragmentAddLugarBinding
import com.example.lugares_cla1.databinding.LugarFilaBinding
import com.lugares_j.ui.lugar.LugarFragmentDirections


class LugarAdapter :RecyclerView.Adapter<LugarAdapter.LugarViewHolder>(){
inner class LugarViewHolder(private val itemBinding: LugarFilaBinding)
    : RecyclerView.ViewHolder(itemBinding.root){
        fun dibuja(ligar: Lugar) {
            itemBinding.tvNombre.text = lugar.nombre
            itemBinding.tvCorreo.text = lugar.correo
            itemBinding.tvTelefono.text = lugar.telefono
            itemBinding.vistasFila.setOnClickListener{

                // creo una accion para navegar a updateLugar pasando un argumento Lugar
                val action = LugarFragmentDirections.actionNavLugarToUpdateLugarFragment(lugar)

                //efectivamente se pasa al fracmento
                itemView.findNavController().navigate(action)
            }

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