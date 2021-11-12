package com.unitec.listadinamica

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(private val cliquear:(Usuario)->Unit):
    ListAdapter<Usuario,UsuarioAdapter.UsuarioViewHolder>(UsuarioDiffCallback) {

        class UsuarioViewHolder(itemView: View,val cliquear:(Usuario)->Unit):
                RecyclerView.ViewHolder(itemView){

                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

object  UsuarioDiffCallback :DiffUtil.ItemCallback<Usuario>(){
    override fun areItemsTheSame(oldItem: Usuario, newItem: Usuario): Boolean {
        return  oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Usuario, newItem: Usuario): Boolean {
        return oldItem.email==newItem.email;
    }

}