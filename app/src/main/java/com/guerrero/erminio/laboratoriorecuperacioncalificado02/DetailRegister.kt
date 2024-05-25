package com.guerrero.erminio.laboratoriorecuperacioncalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.guerrero.erminio.laboratoriorecuperacioncalificado02.databinding.ActivityDetailRegisterBinding

class DetailRegister : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerButtons()
        intent.extras?.let { showData(it) }
    }

    private fun showData(paramExtras: Bundle){
        val fullname = paramExtras.getString(KEY_FULLNAME)
        val phone = paramExtras.getString(KEY_NUMBERPHONE)
        val lastNames = paramExtras.getString(KEY_LASTNAMES)
        val adress = paramExtras.getString(KEY_ADRESS)

        binding.fullName.text = fullname
        binding.lastname.text = lastNames
        binding.phoneNumber.text = phone
        binding.adrees.text = adress
    }

    private fun listenerButtons(){
        binding.ibLlamar.setOnClickListener {
            goCall()
        }
        binding.ibWsp.setOnClickListener {
            goWsp()
        }
        binding.ibMaps.setOnClickListener {
            goGoogleMaps()
        }
    }

    private fun goWsp(){
        val phone = binding.phoneNumber.text.toString()
        val message = "Hola, ${binding.fullName.text.toString()}"

        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://wa.me/$phone?text=$message")
        }
        startActivity(intent)
    }

    private fun goGoogleMaps(){
        val adress = binding.adrees.text.toString()
        val gmmIntentUri = Uri.parse("geo:0,0?q=$adress")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }
    private fun goCall(){
        val phone = binding.phoneNumber.text.toString()
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }
        startActivity(intent)
    }
}