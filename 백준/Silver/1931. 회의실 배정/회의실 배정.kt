package jimin.`6week`

import java.io.BufferedReader
import java.io.InputStreamReader

//val maxIdx = nums.indices.maxBy { nums[it] } ?: -1
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    var meetingList = mutableListOf<Pair<Int, Int>>()
    repeat(readLine().toInt()) {
        val input = readLine().split(" ").map { it.toInt() }
        meetingList.add(Pair(input[0], input[1]))
    }

    meetingList.sortWith(compareBy({ it.first }, {it.second}))
    meetingList.reverse()
    //println(meetingList)

    var max = meetingList[0].first
    var num = 1

    for (i in 1 until meetingList.size) {
        if (meetingList[i].second <= max){
            max = meetingList[i].first
            num += 1
        }
    }
    println(num)
}

