package com.example.lectorqr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lectorqr.databinding.ActivityMainBinding
import com.example.lectorqr.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recibido = intent.extras
        val datos = recibido?.get("INTENT_RESULTADO")
        binding.txtResult.text = "${datos.toString()}"

    }
}