package jimin.`7week`

import java.io.BufferedReader
import java.io.InputStreamReader

/*
<문제>

<구현 방법>

<트러블 슈팅>
 */

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val recordList = readLine().split(" ").map { it.toInt() }
    val result = MutableList(n) { 0 }

    recordList.forEachIndexed { index, info ->
        if (index == 0) {
            result[info] = index + 1
        } else {
            var num = 0
            run breaker@ {
                repeat(n) {
                    if (result[it] == 0) {
                        if (num == info) {
                            result[it] = index + 1
                            return@breaker
                        }
                        num += 1
                    }


                }
            }
        }
    }
    println(result.joinToString(" "))
}
