package com.example.tugasandroid

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.formulir_pendaftaran.*

class FormulirPendaftaran : AppCompatActivity(), View.OnClickListener {
    private var namaUser = ""
    private var nimUser = ""
    private var jurusanUser = ""
    private var alamatUser = ""
    private var jenisKelaminUser = ""
    private var tanggalLahir = ""
    private var bulanLahir = ""
    private var tahunLahir = ""

    private val inputData: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            namaUser = text_input_nama.text.toString().trim()
            nimUser = text_input_nim.text.toString().trim()
            jurusanUser = text_input_jurusan.text.toString().trim()
            alamatUser = text_input_alamat.text.toString().trim()
            tanggalLahir = text_input_tanggal.text.toString().trim()
            bulanLahir = text_input_bulan.text.toString().trim()
            tahunLahir = text_input_tahun.text.toString().trim()

            getRadioText()
            enableSaveBtn()
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulir_pendaftaran)

        val goToActivity = findViewById<View>(R.id.button_backformulir)
        goToActivity.setOnClickListener { onBackPressed() }

        text_input_nama.addTextChangedListener(inputData)
        text_input_nim.addTextChangedListener(inputData)
        text_input_jurusan.addTextChangedListener(inputData)
        text_input_alamat.addTextChangedListener(inputData)
        text_input_tanggal.addTextChangedListener(inputData)
        text_input_bulan.addTextChangedListener(inputData)
        text_input_tahun.addTextChangedListener(inputData)

        initiateUI()
    }

    private fun initiateUI() {
        button_backformulir.setOnClickListener(this)
        button_saveformulir.setOnClickListener(this)
    }

    private fun getRadioText() {
        radio_group_jeniskelamin.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener() {
                radioGroup, i ->
            val radio: RadioButton = findViewById(i)
            jenisKelaminUser = radio.text.toString().trim()
        })
    }

    private fun enableSaveBtn() {
        button_saveformulir.setEnabled(
            !namaUser.isEmpty() && !alamatUser.isEmpty() &&
                    !nimUser.isEmpty() && !jurusanUser.isEmpty() && !tanggalLahir.isEmpty()
                    && !bulanLahir.isEmpty() && !tahunLahir.isEmpty()
        )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_saveformulir -> {
                val intent = Intent(this, TampilanBiodata::class.java)

                intent.putExtra("nama_user", namaUser)
                intent.putExtra("nim_user", nimUser)
                intent.putExtra("jurusan_user", jurusanUser)
                intent.putExtra("jenis_kelamin_user", jenisKelaminUser)
                intent.putExtra("alamat_user", alamatUser)
                intent.putExtra("tanggallahir_user", tanggalLahir)
                intent.putExtra("bulanlahir_user", bulanLahir)
                intent.putExtra("tahunlahir_user", tahunLahir)

                startActivity(intent)
            }
                R.id.button_backformulir -> {
                    onBackPressed()
            }
        }
    }
}