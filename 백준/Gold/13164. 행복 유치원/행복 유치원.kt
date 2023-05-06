package jimin.`34week`

import java.util.*

class `행복 유치원` {
    fun solve() {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val students = readln().split(" ").map { it.toInt() }
        val pq = PriorityQueue(Comparator<Pair<Int, Int>> { a, b -> if (a.first != b.first) b.first - a.first else b.second - a.second })

        for (i in 0 until n - 1) {
            pq.add(Pair(students[i + 1] - students[i], i))
        }
        var tmp = 0
        val idxes = mutableListOf<Int>()
        while(pq.isNotEmpty() && tmp < k - 1) {
            idxes.add(pq.poll().second)
            tmp += 1
        }
        //println(idxes)
        var first = 0
        var result = 0
        idxes.forEach{ idx ->
            result += students[idx] - students[first]
            first = idx + 1
        }
        result += students.last() - students[first]

        println(result)
    }
}

fun main() {
    `행복 유치원`().solve()
}