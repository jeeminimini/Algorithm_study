package jimin.`2week`

import kotlin.math.max

fun main() {
    var numberList = arrayListOf<Int>()
    repeat(readln().toInt()){
        numberList.add(readln().toInt())
    }
    var max = 1
    numberList.forEachIndexed { index, num ->
        val continuous = numberList.count { it <= num + 4 && it >= num }
        max = max(max, continuous)
    }
    println(5 - max)
}