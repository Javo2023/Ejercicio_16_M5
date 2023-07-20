package com.example.ejercicio_16_m5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ejercicio_16_m5.databinding.ItemLayoutBinding

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>(){
    var paises = mutableListOf<Pais>()
    var callback: PaisCallback?= null

    fun setPaisCallback(c: PaisCallback){
       this.callback = c
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }
    fun setData(paises: List<Pais>){
        this.paises = paises.toMutableList()
    }

     inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder (binding.root){
        fun bind(item : Pais){
            binding.textNombrePais.text = item.nombre
            binding.imageBandera.load(item.imgUrl)
            binding.cardView.setOnClickListener(View.OnClickListener {

                val texto = "Pais:${item.nombre}    Poblacion:${item.poblacion}"
                callback?.showCountry(texto)
            })



        }





    }
    interface PaisCallback {
        fun showCountry(s: String)
    }
}