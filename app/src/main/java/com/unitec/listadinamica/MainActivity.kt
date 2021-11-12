package com.unitec.listadinamica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var u1=Usuario()
        u1.email="jc@gmail"
        u1.edad=48
        u1.nombre="Juan"

        var u2=Usuario()
        u2.nombre="Floky"
        u2.edad=3
        u2.email="floky@gmail.com"
        var usuarios= arrayListOf<Usuario>(u1,u2)

        val usuariosAdapter = UsuarioAdapter { usuario -> adaptadorClick(usuario) }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = usuariosAdapter

        usuariosAdapter.submitList(usuarios)



    }
    fun adaptadorClick(usuario: Usuario){
        var intent = Intent(this, DetallesActivity::class.java)

        intent.putExtra("usuario",usuario)
        startActivity(intent)
    }
}