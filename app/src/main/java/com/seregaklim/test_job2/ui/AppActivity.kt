package com.seregaklim.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seregaklim.test_job2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


val abPl = 100
    val tra =12
    val prM = abPl/tra //стоимость 1 миг.

   val x=15
    val itog = if (x<=tra) {abPl} else {x-tra * prM+abPl}





}

