package jimin.`12week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, length) = readLine().split(" ").map { it.toInt() }
    val waters = readLine().split(" ").map { it.toInt() }.toMutableList()

    waters.sort()
    var index = 0
    var tape = waters[0]
    var num = 1
    while (index < n) {
        if (waters[index] !in tape until tape + length) {
            tape = waters[index]
            num += 1
        }
        index += 1
        //println("index $index num $num tape $tape")
    }
    println(num)
}
