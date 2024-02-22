package com.example.latihan_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
        supportActionBar?.hide()
    }
}