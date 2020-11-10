package com.example.tugasandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.tampilan_data.*

class TampilanBiodata : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tampilan_data)
        val goToActivity = findViewById<View>(R.id.button_backtampilan)
        goToActivity.setOnClickListener { Intent(this, Home::class.java) }
        initiateUI()
    }

    private fun initiateUI() {
        val intent = intent
        button_backtampilan.setOnClickListener(this)

        text_view_tampilan_nama.text = intent.getStringExtra("nama_user")
        text_view_tampilan_nim.text = intent.getStringExtra("nim_user")
        text_view_tampilan_jurusan.text = intent.getStringExtra("jurusan_user")
        text_view_tampilan_jeniskelamin.text = intent.getStringExtra("jenis_kelamin_user")
        text_view_tampilan_alamat.text = intent.getStringExtra("alamat_user")
        text_view_tampilan_tanggallahir.text = intent.getStringExtra("tanggallahir_user")
        text_view_tampilan_bulanlahir.text = intent.getStringExtra("bulanlahir_user")
        text_view_tampilan_tahunlahir.text = intent.getStringExtra("tahunlahir_user")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_backtampilan -> {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
        }
    }
}