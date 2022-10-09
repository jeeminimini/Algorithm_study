package jimin.`4week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val scoreInfo = mutableListOf<MutableList<String>>()
    var team1Score = 0
    var team1Time = 0
    var team2Score = 0
    var team2Time = 0
    val lastTime = 48 * 60
    repeat(readLine().toInt()) {
        scoreInfo.add(readLine().split(" ").toMutableList())
    }
    scoreInfo.forEachIndexed { index, strings ->
        val (m, s) = scoreInfo[index][1].split(":").map { it.toInt() }
        val totalTime = m * 60 + s
        if (scoreInfo[index][0] == "1") team1Score += 1
        else team2Score += 1

        if (index == scoreInfo.size - 1) {
            if (team1Score > team2Score) {
                team1Time += lastTime - totalTime
            } else if (team1Score < team2Score) {
                team2Time += lastTime - totalTime
            }
        } else {
            val(nextM, nextS) = scoreInfo[index + 1][1].split(":").map { it.toInt() }
            val nextTime = nextM * 60 + nextS
            if (team1Score > team2Score) {
                team1Time += nextTime - totalTime
            } else if (team1Score < team2Score) {
                team2Time += nextTime - totalTime
            }
        }
    }
    println("${(team1Time/60).toString().padStart(2,'0')}:${(team1Time%60).toString().padStart(2,'0')}")
    println("${(team2Time/60).toString().padStart(2,'0')}:${(team2Time%60).toString().padStart(2,'0')}")
}