package jimin.`5week`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/*
<문제>

<구현 방법>

<트러블 슈팅>
 */

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val treeList = arrayListOf<Int>()
    repeat(readLine().toInt()) {
        treeList.add(readLine().toInt())
    }

    treeList.sort()

    val treeDistanceList = arrayListOf<Int>()
    treeList.forEachIndexed { index, _ ->
        if (index != treeList.size - 1) {
            treeDistanceList.add(treeList[index + 1] - treeList[index])
        }
    }

    val minDistance = treeDistanceList.minOf { it }
    var sum = 0
    for (i in minDistance downTo 1){
        if (treeDistanceList.all { it % i == 0}) {
            treeDistanceList.forEach {
                sum += it / i - 1
            }
            println(sum)
            break
        }
    }
}
