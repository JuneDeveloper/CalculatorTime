package com.example.calculatortime

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var hourOneOperandET: EditText
    private lateinit var minOneOperandET: EditText
    private lateinit var secOneOperandET: EditText

    private lateinit var hourTwoOperandET: EditText
    private lateinit var minTwoOperandET: EditText
    private lateinit var secTwoOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button

    private lateinit var buttonResetBTN: Button
    private lateinit var buttonExitBTN: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hourOneOperandET = findViewById(R.id.hourOneOperandET)
        minOneOperandET = findViewById(R.id.minOneOperandET)
        secOneOperandET = findViewById(R.id.secOneOperandET)

        hourTwoOperandET = findViewById(R.id.hourTwoOperandET)
        minTwoOperandET = findViewById(R.id.minTwoOperandET)
        secTwoOperandET = findViewById(R.id.secTwoOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)

        buttonResetBTN = findViewById(R.id.buttonResetBTN)
        buttonExitBTN = findViewById(R.id.buttonExitBTN)

        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)

        buttonResetBTN.setOnClickListener(this)
        buttonExitBTN.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        var check = true
        val h1:Int
        val m1:Int
        val s1:Int
        val h2:Int
        val m2:Int
        val s2:Int
        if (hourOneOperandET.text.isEmpty()) h1 = 0
        else h1 = Integer.parseInt(hourOneOperandET.text.toString())*3600
        if (minOneOperandET.text.isEmpty()) m1 = 0
        else m1 = Integer.parseInt(minOneOperandET.text.toString())*60
        if (secOneOperandET.text.isEmpty()) s1 = 0
        else s1 = Integer.parseInt(secOneOperandET.text.toString())
        if (hourTwoOperandET.text.isEmpty()) h2 = 0
        else h2 = Integer.parseInt(hourTwoOperandET.text.toString())*3600
        if (minTwoOperandET.text.isEmpty()) m2 = 0
        else m2 = Integer.parseInt(minTwoOperandET.text.toString())*60
        if (secTwoOperandET.text.isEmpty()) s2 = 0
        else s2 = Integer.parseInt(secTwoOperandET.text.toString())

        val first = h1+m1+s1
        val second = h2+m2+s2

        val result = when(v.id) {
            R.id.buttonSumBTN -> Operation(first, second).sum()
            R.id.buttonDifBTN -> Operation(first, second).dif()
            R.id.buttonResetBTN -> {
                hourOneOperandET.text.clear()
                minOneOperandET.text.clear()
                secOneOperandET.text.clear()
                hourTwoOperandET.text.clear()
                minTwoOperandET.text.clear()
                secTwoOperandET.text.clear()
                check = false
            }
            R.id.buttonExitBTN -> finish()
            else -> 0.0
        }
        if (!check) resultTV.text = "Результат" else resultTV.text = result.toString()
    }
}