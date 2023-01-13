package jimin.`18week`

import kotlin.math.abs

var n = 0
var s = 0
var result = 0
fun main() {
    readln().split(" ").map { it.toInt() }.apply {
        n = first()
        s = last()
    }
    val numbers = readln().split(" ").map { it.toInt() } as MutableList
    numbers.sort()
    getNumber(numbers, MutableList(n) { false }, 0)
    println(result)
}

fun getNumber(numbers: MutableList<Int>, visited: MutableList<Boolean>, idx: Int) {
    var sum = 0
    if (visited.any { it }) {
        visited.forEachIndexed { idx, visit ->
            if (visit) {
                sum += numbers[idx]
            }
        }
        //println("visited $visited sum $sum")
        if (sum * s <= 0 && sum > s) {
            //println("탈출!")
            return@getNumber
        } else if (sum == s) {
            result += 1
            //println("정답")
        }
    }

    for (i in idx until n) {
        if (visited[i].not()) {
            visited[i] = true
            getNumber(numbers, visited, i + 1)
            visited[i] = false
        }
    }
}