package com.unitec.listadinamica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(private val cliquear:(Usuario)->Unit):
    ListAdapter<Usuario,UsuarioAdapter.UsuarioViewHolder>(UsuarioDiffCallback) {

        class UsuarioViewHolder(itemView: View,val cliquear:(Usuario)->Unit):
                RecyclerView.ViewHolder(itemView){
           private var usuarioEmail=itemView.findViewById<TextView>(R.id.txtEmail)
            private var usuarioNombre=itemView.findViewById<TextView>(R.id.txtNombre)
            private var usuarioEdad=itemView.findViewById<TextView>(R.id.txtEdad)
            private var usuarioActual:Usuario?=null
init {
    itemView.setOnClickListener {
           usuarioActual?.let {
               cliquear(it)
           }
    }
}
            fun enlazar(usuario: Usuario){
                usuarioActual=usuario
                usuarioEmail.text=usuario.email
                usuarioNombre.text=usuario.nombre
                usuarioEdad.text=usuario.edad.toString()
            }

                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
     val view=LayoutInflater
         .from(parent.context)
         .inflate(R.layout.usuario_item, parent, false)
        return  UsuarioViewHolder(view,cliquear)

    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario =getItem(position)
        holder.enlazar(usuario)
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