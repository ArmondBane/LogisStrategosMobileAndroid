package com.goodcomp.logisstrategos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goodcomp.logisstrategos.R
import com.goodcomp.logisstrategos.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}