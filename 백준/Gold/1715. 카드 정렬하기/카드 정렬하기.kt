package jimin.`35week`

import java.util.*

class `카드 정렬` {
    fun solve() {
        val priorityQueue = PriorityQueue<Int>()
        repeat(readln().toInt()) {
            priorityQueue.add(readln().toInt())
        }
        var sum = 0
        while(priorityQueue.size >= 2) {
            val first = priorityQueue.poll()
            val second = priorityQueue.poll()
            sum += first + second
            priorityQueue.add(first + second)
        }

        println(sum)
    }
}

fun main() {
    `카드 정렬`().solve()
}