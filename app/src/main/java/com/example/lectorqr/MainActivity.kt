package com.example.lectorqr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import android.widget.Toast
import com.example.lectorqr.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLeer.setOnClickListener { iniciarScanner() }
    }
    private fun iniciarScanner(){
       val integrator =  IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Escaneando QR")
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val resultado = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if (resultado != null){
            if (resultado.contents == null){
                Toast.makeText(this, "Cancelado...", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("INTENT_RESULTADO", resultado.contents)
                startActivity(intent)
                Toast.makeText(this, "El Valor es: ${resultado.contents}", Toast.LENGTH_LONG).show()
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }




    }
}