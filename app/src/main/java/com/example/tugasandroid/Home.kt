package com.example.tugasandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tugasandroid.FormulirPendaftaran

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val goToActivity = findViewById<View>(R.id.buttonFormulirPendaftaran)
        goToActivity.setOnClickListener {
            startActivity(Intent(this@Home, FormulirPendaftaran::class.java))
        }
    }
}