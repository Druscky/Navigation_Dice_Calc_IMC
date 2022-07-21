package com.promedia.navigation_dice_calculator_imc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.promedia.navigation_dice_calculator_imc.databinding.FragmentImcBinding


class imc_Fragment : Fragment() {
    private var _b: FragmentImcBinding? = null
    private val b get() = _b!!
    private var height = 150
    private var weight = 75
    private var doubleHeight = 2.25  //
    private var IMC = 33.33

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _b = FragmentImcBinding.inflate(inflater, container, false)
        return b.root


        // Meter ésto en ViewCreate
        b.sBarAltura.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                b.tv150200.text = progress.toString().plus("/200")
                height = progress
            }

            override fun onStartTrackingTouch(seek: SeekBar?) {}
            override fun onStopTrackingTouch(seek: SeekBar?) {
                calcIMC()
            }
        })

        b.sBarPeso.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                b.tv75150.text = progress.toString().plus("/150")
                weight = progress
            }

            override fun onStartTrackingTouch(seek: SeekBar?) {}
            override fun onStopTrackingTouch(seek: SeekBar?) {
                calcIMC()
            }
        })

    }

    fun alertCustom(view:View){
        val inflater = this!!.layoutInflater
        val custom_layout = inflater.inflate(R.layout.fragment_tabla_i_m_c_, null)

        AlertDialog.Builder(this!!)
            .setView(custom_layout)
            .setPositiveButton(R.string.tvAceptar, null)
            .show()
    }

    fun calcIMC() {
        doubleHeight = height.times(height)/10000.0
        IMC = Math.round((weight/doubleHeight)
            .times(100))
            .div(100.0)
        b.tvResultado.text = IMC.toString()
        calcObesidad()
    }
    fun calcObesidad() {
        val msj = when (IMC){
            in 0.0..15.99 -> "Delgadez Severa"
            in 16.00..16.99 -> "Delgadez Moderada"
            in 17.00..18.49 -> "Delgadez Leve"
            in 18.50..24.99 -> "Peso Normal"
            in 25.00..29.99 -> "Preobesidad"
            in 30.00..34.99 -> "Obesidad Leve"
            in 35.00..39.99 -> "Obesidad Media"
            else -> "Obesidad Mórbida"
        }
        val color = when (IMC){
            in 0.0..15.99 -> R.color.dark_blue
            in 16.00..16.99 -> R.color.blue
            in 17.00..18.49 -> R.color.sky_blue
            in 18.50..24.99 -> R.color.green
            in 25.00..29.99 -> R.color.lima
            in 30.00..34.99 -> R.color.cake_orange
            in 35.00..39.99 -> R.color.orange
            else -> R.color.red
        }

        val s = Snackbar.make(b.root, msj, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(this, color))
            .setTextColor(ContextCompat.getColor(this, R.color.dark_gray))
            .setAction("Ver Tabla") { showTable() }
        s.show()
    }
    fun showTable(){
        val dialog = TablaIMC_Fragment()
        dialog.show(supportFragmentManager, "TablaPeso")
    }
}






