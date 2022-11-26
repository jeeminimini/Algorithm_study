package jimin.`11week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().trim().split(" ").map{ it.toLong() }
    val course = readLine().trim().split(" ").map{ it.toLong() }

    var distance = 0L
    kotlin.run {
        (course + course.reversed()).forEachIndexed { idx, it ->
            if (k in distance until  distance + it){
                println(
                    if (idx < n) idx + 1
                    else 2*n - idx
                )
                return@run
            }
            distance += it
        }
    }

}
