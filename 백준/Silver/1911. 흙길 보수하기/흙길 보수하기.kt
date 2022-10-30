package jimin.`7week`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

/*
<문제>

<구현 방법>

<트러블 슈팅>
 */

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val poolInfo = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (p1, p2) = readLine().split(" ").map { it.toInt() }
        poolInfo.add(Pair(p1, p2))
    }
    poolInfo.sortWith(compareBy { it.first })
    var boardNum = 0
    var index = 0
    poolInfo.forEach { pool ->
        
        if (index < pool.first){
            val length = pool.second - pool.first
            //println("length $length ${length / l}")
            val newBoard= if (length % l == 0 ) length / l else length / l + 1
            index = pool.first + newBoard * l
            boardNum += newBoard
            //println("index $index pool.first ${pool.first}")
        } else if (index > pool.second) {
            return@forEach
        } else {
            val length = pool.second - index
            //println("length $length ${length / l}")
            val newBoard= if (length % l == 0 ) length / l else length / l + 1
            index = index + newBoard * l
            boardNum += newBoard
            //println("index $index pool.first ${pool.first}")
        }

    }

    println(boardNum)

}
