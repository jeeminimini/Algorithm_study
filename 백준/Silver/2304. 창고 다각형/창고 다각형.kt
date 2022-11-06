package jimin.`8week`

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val pillarList = mutableListOf<Pair<Int, Int>>()
    repeat(readLine().toInt()) {
        val (l, h) = readLine().split(" ").map { it.toInt() }
        pillarList.add(Pair(l, h))
    }
    pillarList.sortWith(compareBy { it.first })

    val realMaxIndex = pillarList.map { it.second }.indexOfLast { it == pillarList.maxOf { it.second } }
    var max = pillarList.first()
    var result = 0
    pillarList.forEachIndexed { index, pair ->
        if (realMaxIndex == index) {
            result += pair.second
        }
        if (pair.second >= max.second) {
            result += max.second * (pair.first - max.first)
            max = pair
        }
    }
    //println(result)
    max = pillarList.last()
    for (i in pillarList.size -1 downTo realMaxIndex){
        if (pillarList[i].second >= max.second) {
            result += max.second * (max.first - pillarList[i].first)
            max = pillarList[i]
        }
    }
    println(result)
}
