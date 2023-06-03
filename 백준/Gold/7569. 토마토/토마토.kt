package jimin.`35week`

import java.lang.Integer.max

class 토마토 {
    private val boxes = mutableListOf<MutableList<MutableList<Int>>>()
    private val dx = mutableListOf(0, 0, 1, -1, 0, 0)
    private val dy = mutableListOf(-1, 1, 0, 0, 0, 0)
    private val dh = mutableListOf(0, 0, 0, 0, 1, -1)
    private var beforeTomato = 0

    fun solve() {
        val (n, m, h) = readln().split(" ").map { it.toInt() }

        val afterTomatoes = mutableListOf<List<Int>>()

        repeat(h) { hh ->
            val singleBox = mutableListOf<MutableList<Int>>()
            repeat(m) { mm ->
                readln().split(" ").map { it.toInt() }.apply {
                    singleBox.add(this as MutableList)
                    this.forEachIndexed { nn, tomato ->
                        when (tomato) {
                            BEFORE -> beforeTomato += 1
                            AFTER -> afterTomatoes.add(listOf(hh, mm, nn, 0))
                        }
                    }
                }
            }
            boxes.add(singleBox)
        }

        val time = bfs(afterTomatoes, m, n, h)

        if (beforeTomato > 0) {
            println(-1)
        } else {
            println(time)
        }

    }

    fun bfs(afterTomatoes: MutableList<List<Int>>, m: Int, n: Int, h: Int): Int {
        val queue = ArrayDeque<List<Int>>()
        afterTomatoes.forEach {
            queue.add(it)
        }
        var maxTime = 0

        while (queue.isNotEmpty()) {
            val (nH, nM, nN, nNum) = queue.removeFirst()

            for (i in 0 until 6) {
                if (nH + dh[i] in 0 until h && nM + dx[i] in 0 until m && nN + dy[i] in 0 until n &&
                        boxes[nH + dh[i]][nM + dx[i]][nN + dy[i]] == BEFORE) {
                    boxes[nH + dh[i]][nM + dx[i]][nN + dy[i]] = AFTER
                    queue.addLast(listOf(nH + dh[i], nM + dx[i], nN + dy[i], nNum + 1))
                    maxTime = max(maxTime, nNum + 1)
                    beforeTomato -= 1
                }
            }
        }

        return maxTime
    }

    companion object {
        const val BEFORE = 0
        const val AFTER = 1
        const val NONE = -1
    }
}

fun main() {
    토마토().solve()
}