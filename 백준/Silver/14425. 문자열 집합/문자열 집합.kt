package jimin.`8week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val strList = mutableListOf<String>()
    repeat(n) {
        strList.add(readLine())
    }
    var result = 0
    repeat(m) {
        val word = readLine()
        if (strList.contains(word)) {
            result += 1
        }
    }
    println(result)

}