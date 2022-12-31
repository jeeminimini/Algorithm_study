package jimin.`13week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val q = n.toString().length - 1
    var sum = if (n < 10) n else 9
    var ten = 1
    repeat(q) {
        ten *= 10
        if (it == q - 1) {
            sum += (n - (ten - 1)) * (it + 2)
        } else {
            sum += (ten * 9) * (it + 2)
        }
    }
    println(sum)
}
