package com.guerrero.erminio.laboratoriorecuperacioncalificado02

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guerrero.erminio.laboratoriorecuperacioncalificado02.databinding.ActivityEjercicio001Binding
import com.guerrero.erminio.laboratoriorecuperacioncalificado02.databinding.ActivityMainBinding

class Ejercicio001 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio001Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio001Binding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnMostrar.setOnClickListener {
            binding.cvData.visibility = View.VISIBLE
        }

        binding.btnOcultar.setOnClickListener {
            binding.cvData.visibility = View.GONE
        }
    }
}