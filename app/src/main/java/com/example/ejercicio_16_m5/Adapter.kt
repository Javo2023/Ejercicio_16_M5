package com.example.ejercicio_16_m5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ejercicio_16_m5.databinding.ItemLayoutBinding

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>(){
    var paises = mutableListOf<Pais>()


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

    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder (binding.root){
        fun bind(pais : Pais){
            binding.textNombrePais.text = pais.nombre
            binding.imageBandera.load(pais.imgUrl)

        }

    }
}