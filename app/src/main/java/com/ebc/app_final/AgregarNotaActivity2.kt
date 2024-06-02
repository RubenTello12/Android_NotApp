package com.ebc.app_final

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ebc.app_final.databinding.ActivityAgregarNota2Binding
import com.ebc.app_final.databinding.ActivityMainBinding

class AgregarNotaActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityAgregarNota2Binding
    private lateinit var db : NotasDataBaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarNota2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDataBaseHelper(this)

        binding.ivGuardarNota.setOnClickListener{
            val titulo = binding.etTitulo.text.toString()
            val descripcion = binding.etDescripcion.text.toString()

            if(!titulo.isEmpty() && !descripcion.isEmpty()){
                guardarNota(titulo, descripcion)
            }else{
                Toast.makeText(applicationContext, "Llene Todos los Campos",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun guardarNota(titulo : String, descripcion : String){
        val nota = Nota(0, titulo, descripcion)
        db.insertNota(nota)
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finishAffinity()
        Toast.makeText(applicationContext, "Nota Agregada Correctamente",Toast.LENGTH_SHORT).show()
    }
}