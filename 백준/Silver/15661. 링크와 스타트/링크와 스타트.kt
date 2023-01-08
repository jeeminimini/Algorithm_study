package jimin.`17week`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

var n: Int = 0
val people = mutableListOf<List<Int>>()
var result = Int.MAX_VALUE
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    repeat(n) {
        people.add(readLine().split(" ").map { it.toInt() })
    }

    for (i in 2..n / 2) {
        getCombination(i, 0, MutableList(n) { false })
    }

    println(result)
}

fun getCombination(size: Int, idx: Int, visited: MutableList<Boolean>) {
    if (visited.filter { it }.size == size) {
        getLevel(visited)
        return
    }

    for (i in idx until n) {
        visited[i] = true
        getCombination(size, i + 1, visited)
        visited[i] = false
    }
}

fun getLevel(visited: MutableList<Boolean>) {
    var teamA = 0
    var teamB = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (visited[i] && visited[j]) {
                teamA += people[i][j] + people[j][i]
            }
            if (visited[i].not() && visited[j].not()) {
                teamB += people[i][j] + people[j][i]
            }
        }
    }
    result = min(abs(teamA - teamB), result)
}