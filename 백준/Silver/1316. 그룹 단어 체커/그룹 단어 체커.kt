package jimin.`12week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var num = n
    repeat(n) {
        val word = readLine()
        var before = word[0]
        val usedAlphabet = mutableSetOf<Char>()
        word.forEach {
            if (it != before) {
                if (it in usedAlphabet) {
                    num--
                    return@repeat
                }
                usedAlphabet.add(before)
                before = it
            }
        }
    }
    println(num)
}
