package com.promedia.navigation_dice_calculator_imc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.promedia.navigation_dice_calculator_imc.databinding.FragmentCalculatorBinding

class Calculator_Fragment : Fragment() {
    private var _b: FragmentCalculatorBinding? = null
    private val b get() = _b!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _b = FragmentCalculatorBinding.inflate(inflater, container, false)
        return b.root
    }

}