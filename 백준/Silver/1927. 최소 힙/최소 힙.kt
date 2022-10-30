package jimin.`7week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs

/*
<문제>


<구현 방법>


<트러블 슈팅>
 */


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val queue = PriorityQueue<Int>()
    repeat(readLine().toInt()) {
        val x = readLine().toInt()
        if (x == 0){
            if (queue.isEmpty()) {
                println("0")
            } else {
                println(queue.poll())
            }
        } else {
            queue.add(x)
        }
    }

}

