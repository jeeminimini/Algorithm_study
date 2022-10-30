package jimin.`7week`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

/*
<문제>

<구현 방법>

<트러블 슈팅>
 */

lateinit var numberList: List<Int>
var max = 0
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    numberList = readLine().split(" ").map { it.toInt() }

    numberList.forEachIndexed { index, _ ->
        //println("index $index")
        dfs(index, MutableList(n) { false }, 0)
    }
    println(max)
}

fun dfs(index: Int, visited: MutableList<Boolean>, result: Int) {
    visited[index] = true

    if (visited.all { true }) {
        if (result > max) {
            max = result
        }
    }

    numberList.forEachIndexed { index2, _ ->
        if (visited[index2].not()) {
            //println("index $index index2 $index2 visited $visited result $result")
            dfs(index2, visited.toMutableList(), result + abs(numberList[index] - numberList[index2]))
        }
    }
}