package jimin.`25week`

import java.lang.Integer.*

class 선수과목 {
    lateinit var classInfo: MutableList<MutableList<Int>>
    lateinit var time: MutableList<Int>
    lateinit var indegree: MutableList<Int>
    fun solve() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        classInfo = MutableList(n + 1) { mutableListOf() }
        time = MutableList(n + 1) { 1 }
        indegree = MutableList(n + 1) { 0 }
        repeat(m) {
            readln().split(" ").map { it.toInt() }.apply {
                classInfo[first()].add(last())
                indegree[last()] += 1
            }
        }

        setClassTime()
        println(time.drop(1).joinToString(" "))
    }

    fun setClassTime() {
        val queue = ArrayDeque<Int>()
        for (i in 1 until indegree.size) {
            if (indegree[i] == 0) {
                queue.add(i)
            }
        }

        while(queue.isNotEmpty()) {
            val now = queue.removeFirst()
            classInfo[now].forEach{
                indegree[it] -= 1
                if (indegree[it] == 0) {
                    queue.add(it)
                    time[it] = max(time[it], time[now] + 1)
                }
            }
        }
    }
}

fun main() {
    선수과목().solve()
}