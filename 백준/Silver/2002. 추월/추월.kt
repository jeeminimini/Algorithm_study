package jimin.`17week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val beforeCars = mutableListOf<String>()
    val afterCars = mutableListOf<String>()
    var result = 0
    repeat(n) {
        beforeCars.add(readLine())
    }
    repeat(n) {
        val car = readLine()
        run {
            repeat(beforeCars.indexOf(car)) {
                if (beforeCars[it] !in afterCars) {
                    result += 1
                    return@run
                }
            }
        }
        afterCars.add(car)
    }
    println(result)
}
