package com.example.calculatortime

import kotlin.time.Duration.Companion.seconds

class Operation(private val first:Int,private val second:Int) {
    fun sum() = first.seconds + second.seconds
    fun dif() = first.seconds - second.seconds

}
