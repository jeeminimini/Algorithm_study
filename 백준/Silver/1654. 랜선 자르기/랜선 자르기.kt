package jimin.`5week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (k, n) = readLine().split(" ").map { it.toInt() }
    val lanCableList = arrayListOf<Long>()
    repeat(k){
        lanCableList.add(readLine().toLong())
    }

    var min = 1L
    var max = lanCableList.sorted().last()
    while (true) {
        if (min > max) {
            println(max)
            break
        }
        val length = (min + max) / 2
        var sum = 0L
        lanCableList.forEach {
            sum += it / length
        }
        if (sum >= n) {
            min = length + 1
        } else {
            max = length - 1
        }
    }
}
