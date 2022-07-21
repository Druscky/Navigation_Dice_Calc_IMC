package com.promedia.navigation_dice_calculator_imc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.promedia.navigation_dice_calculator_imc.databinding.FragmentDiceBinding


class Dice_Fragment : Fragment() {
    private var _b: FragmentDiceBinding? = null
    private val b get() = _b!!
    private lateinit var myView : View
    private val dados = arrayOf<Int>(
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)
    private var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _b = FragmentDiceBinding.inflate(inflater, container, false)
        return b.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.ivDado1.setOnClickListener { clickOnDado() }
        b.ivDado2.setOnClickListener { clickOnDado() }

    }

    fun clickOnDado(){
        val d1 = (1..6).random()
        val d2 = (1..6).random()
        b.ivDado1.setImageResource(dados[d1-1])
        b.ivDado2.setImageResource(dados[d2-1])
        b.tvContador.text = (d1 + d2).toString()
    }
}




