package com.example.calculatortime

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbarMain:androidx.appcompat.widget.Toolbar

    private lateinit var hourOneOperandET: EditText
    private lateinit var minOneOperandET: EditText
    private lateinit var secOneOperandET: EditText

    private lateinit var hourTwoOperandET: EditText
    private lateinit var minTwoOperandET: EditText
    private lateinit var secTwoOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button

    private lateinit var resultTV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор"
        toolbarMain.subtitle = "Версия 1.0"
        toolbarMain.setLogo(R.drawable.timer)


        hourOneOperandET = findViewById(R.id.hourOneOperandET)
        minOneOperandET = findViewById(R.id.minOneOperandET)
        secOneOperandET = findViewById(R.id.secOneOperandET)

        hourTwoOperandET = findViewById(R.id.hourTwoOperandET)
        minTwoOperandET = findViewById(R.id.minTwoOperandET)
        secTwoOperandET = findViewById(R.id.secTwoOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)

        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.resetMenuMain -> {
                hourOneOperandET.text.clear()
                minOneOperandET.text.clear()
                secOneOperandET.text.clear()
                hourTwoOperandET.text.clear()
                minTwoOperandET.text.clear()
                secTwoOperandET.text.clear()
                resultTV.text = "Результат"
                resultTV.setTextColor(Color.BLACK)
                Toast.makeText(
                    applicationContext,
                    "Данные очищены",
                    Toast.LENGTH_LONG
                ).show()}
            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext,
                    "Приложение закрыто",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
            R.id.buttonSumBTN -> {
                Toast.makeText(
                    applicationContext,
                    "Результат",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {

        val h1: Int
        val m1: Int
        val s1: Int
        val h2: Int
        val m2: Int
        val s2: Int

        if (hourOneOperandET.text.isEmpty()) h1 = 0
        else h1 = Integer.parseInt(hourOneOperandET.text.toString()) * 3600
        if (minOneOperandET.text.isEmpty()) m1 = 0
        else m1 = Integer.parseInt(minOneOperandET.text.toString()) * 60
        if (secOneOperandET.text.isEmpty()) s1 = 0
        else s1 = Integer.parseInt(secOneOperandET.text.toString())
        if (hourTwoOperandET.text.isEmpty()) h2 = 0
        else h2 = Integer.parseInt(hourTwoOperandET.text.toString()) * 3600
        if (minTwoOperandET.text.isEmpty()) m2 = 0
        else m2 = Integer.parseInt(minTwoOperandET.text.toString()) * 60
        if (secTwoOperandET.text.isEmpty()) s2 = 0
        else s2 = Integer.parseInt(secTwoOperandET.text.toString())

        val first = h1 + m1 + s1
        val second = h2 + m2 + s2

        when(v.id) {
            R.id.buttonSumBTN -> {
                val x = Operation(first, second).sum()
                resultTV.text = x.toString()
                resultTV.setTextColor(Color.RED)
                Toast.makeText(
                    applicationContext,
                    "Результат: $x",
                    Toast.LENGTH_LONG
                ).show()
            }
            R.id.buttonDifBTN -> {
                val y = Operation(first, second).dif()
                resultTV.text = y.toString()
                resultTV.setTextColor(Color.RED)
                Toast.makeText(
                    applicationContext,
                    "Результат: $y",
                    Toast.LENGTH_LONG
                ).show()
            }
            else -> 0.0
        }
    }
}