package com.promedia.navigation_dice_calculator_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.promedia.navigation_dice_calculator_imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.meDice -> {
                    Navigation.findNavController(b.fragmentContainerView)
                        .navigate(R.id.dice_Fragment)
                    true
                }
                R.id.meCalculator -> {
                    Navigation.findNavController(b.fragmentContainerView)
                        .navigate(R.id.calculator_Fragment)
                    true
                }
                R.id.meIMC -> {
                    Navigation.findNavController(b.fragmentContainerView)
                        .navigate(R.id.imc_Fragment)
                    true
                }
                else -> false
            }
        }
    }
}