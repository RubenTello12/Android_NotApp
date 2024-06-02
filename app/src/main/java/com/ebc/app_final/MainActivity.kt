package com.ebc.app_final

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebc.app_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db : NotasDataBaseHelper
    private lateinit var notasAdaptador: NotasAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDataBaseHelper(this)

        notasAdaptador = NotasAdaptador(db.getAllNotas(), this)

        binding.NotasRv.layoutManager = LinearLayoutManager(this)
        binding.NotasRv.adapter = notasAdaptador

        binding.FABAgregarNota.setOnClickListener{
            startActivity(Intent(applicationContext, AgregarNotaActivity2::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        notasAdaptador.refrescarLista(db.getAllNotas())
    }
}