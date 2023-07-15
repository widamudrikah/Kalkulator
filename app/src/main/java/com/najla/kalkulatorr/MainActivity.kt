package com.najla.kalkulatorr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.najla.kalkulatorr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambah.setOnClickListener {
            //input
            val awal = binding.edtNil1.text.toString()
            val kedua = binding.edtNil2.text.toString()
            validasi(awal,kedua,'+')

        }

        binding.btnKurang.setOnClickListener {
            val awal = binding.edtNil1.text.toString()
            val kedua = binding.edtNil2.text.toString()

            validasi(awal,kedua,'-')
        }

        binding.btnBagi.setOnClickListener {
            val awal = binding.edtNil1.text.toString()
            val kedua = binding.edtNil2.text.toString()

            validasi(awal,kedua,'/')
        }

        binding.btnKali.setOnClickListener {
            val awal = binding.edtNil1.text.toString()
            val kedua = binding.edtNil2.text.toString()

            validasi(awal,kedua,'x')
        }
    }

    private fun validasi(awal: String, kedua: String, operator:Char) {
        if (awal.isEmpty()){
            binding.edtNil1.error = "Isi dulu bro"

        }
        if (kedua.isEmpty()){
            binding.edtNil2.error = "Isi dulu bro"
        }
        if (awal.isNotEmpty() && kedua.isNotEmpty()){
            perhitungan(awal.toDouble(), kedua.toDouble(), operator)
        }
    }

    private fun perhitungan(awal: Double, kedua: Double, operator: Char) {
        var hasil = 0.0

        if (operator == '-'){
            hasil = awal - kedua
        }else if (operator == '+'){
            hasil = awal + kedua
        }else if (operator == '/'){
            hasil = awal / kedua
        }else if (operator == 'x'){
            hasil = awal * kedua
        }else{
            hasil = 0.0
        }
        binding.tvHasil.text = hasil.toString()
    }
}