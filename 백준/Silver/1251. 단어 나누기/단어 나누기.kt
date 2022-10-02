package jimin.`3week`

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val word = readLine().chunked(1)
    var minWord = word.subList(0, 2).joinToString("") + word.subList(2, word.size).joinToString("").reversed()
    for (i in 1 until word.size - 1) {
        for (j in i + 1 until word.size) {
            val reversedWord =
                word.subList(0, i).joinToString("").reversed() + word.subList(i, j).joinToString("")
                    .reversed() + word.subList(j, word.size)
                    .joinToString("").reversed()
            minWord = minString(minWord, reversedWord)
        }

    }
    println(minWord)

}

fun minString(s1: String, s2: String): String {
    return if (s1 <= s2) s1
    else s2
}