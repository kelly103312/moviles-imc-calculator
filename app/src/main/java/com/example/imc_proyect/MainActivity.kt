package com.example.imc_proyect

import android.os.Bundle
import android.text.Editable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imc_proyect.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onButton()

    }

    private fun onButton(){
        binding.btnCalcular.setOnClickListener {
            val stature = binding.valueStature.text.toString().toFloatOrNull()
            val weight = binding.valueWeight.text.toString().toFloatOrNull()
            var imc : Float = 0f

            if(stature != null && weight != null){
                imc = weight / (stature*stature)
            }

            val resultText = findViewById(R.id.value_result) as TextView
            resultText.setText(validateImc(imc))
            println(imc)
        }
    }

    private fun validateImc(imc : Float): String {
        var result = "Obesidad"
        if(imc < 18.5F){
            result = "Peso bajo"
        }
        if( imc == 18.5F || imc < 24.9F){
            result = "Peso normal"
        }
        if(imc == 25F || imc < 29.9F){
            result = "Sobrepeso"
        }
        return result
    }
}