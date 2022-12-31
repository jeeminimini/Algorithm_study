package jimin.`13week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, s, p) = readLine().split(" ").map { it.toInt() }
    if (n == 0) {
        println(1)
        return@with
    }
    val scoreList = readLine().split(" ").map { it.toInt() }.toMutableList()
    if (n == p) {
        if (scoreList.last() >= s) {
            println(-1)
            return@with
        }
    }
    scoreList.add(s)
    scoreList.sortDescending()
    println(scoreList.indexOf(s) + 1)
}
