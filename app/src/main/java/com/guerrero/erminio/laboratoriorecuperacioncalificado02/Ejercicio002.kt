package com.guerrero.erminio.laboratoriorecuperacioncalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guerrero.erminio.laboratoriorecuperacioncalificado02.databinding.ActivityEjercicio002Binding

class Ejercicio002 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio002Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio002Binding.inflate(layoutInflater)
        setContentView(binding.root)

        observeComponents()



    }

    private fun observeComponents(){
        binding.btnSave.setOnClickListener() {
            if (isEmptyInputs()) {
                AlertDialog.Builder(this)
                    .setTitle("Campos vacíos")
                    .setMessage("Por favor, llena todos los campos antes de continuar.")
                    .setPositiveButton("Entendido") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            } else {
                goDetailActivity()
            }
        }
    }

    private fun goDetailActivity(){
        val fullname = binding.fullName.text.toString()
        val lastNames = binding.lastName.text.toString()
        val cellPhone = binding.cellPhone.text.toString()
        val adress = binding.adress.text.toString()


        //val intent = Intent(this, DetailActivity::class.java)
        val intent = Intent(this, DetailRegister::class.java)
        intent.putExtra(KEY_FULLNAME, fullname)
        intent.putExtra(KEY_LASTNAMES, lastNames)
        intent.putExtra(KEY_NUMBERPHONE, cellPhone)
        intent.putExtra(KEY_ADRESS, adress)

        startActivity(intent)
    }

    private fun isEmptyInputs():Boolean{
        return binding.fullName.text.isEmpty() ||
                binding.lastName.text.isEmpty() ||
                binding.cellPhone.text.isEmpty() ||
                binding.adress.text.isEmpty()

    }
}