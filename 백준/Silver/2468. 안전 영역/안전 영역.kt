package jimin.`20week`

import java.lang.Integer.min
import java.lang.Integer.max

class `안전 영역` {
    private val area = mutableListOf<List<Int>>()
    private var n = 0

    fun solve() {
        n = readln().toInt()
        var minRain = Int.MAX_VALUE
        var maxRain = 0
        repeat(n) {
            readln().split(" ").map { it.toInt() }.apply {
                minRain = min(minRain, this.minOf { it })
                maxRain = max(maxRain, this.maxOf { it })
                area.add(this)
            }
        }

        var result = Pair(0, minRain)
        for (h in minRain - 1..maxRain) {
            val visited = MutableList(n) { MutableList(n) { false } }
            var num = 0
            for (x in 0 until n) {
                for (y in 0 until n) {
                    if (visited[x][y].not() && area[x][y] > h) {
                        bfs(h, x, y, visited)
                        num += 1
                    }
                }
            }
            if (result.first < num) {
                result = Pair(num, h)
            }
        }

        println(result.first)
    }

    fun bfs(h: Int, x: Int, y: Int, visited: MutableList<MutableList<Boolean>>) {
        val queue = mutableListOf<Point>(Point(x, y))
        val dx = mutableListOf(0, 0, -1, 1)
        val dy = mutableListOf(-1, 1, 0, 0)
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val height = queue.removeAt(0)
            for (i in 0..3) for (j in 0..3) {
                if (height.x + dx[i] in 0 until n && height.y + dy[i] in 0 until n
                    && visited[height.x + dx[i]][height.y + dy[i]].not()) {
                    if (area[height.x + dx[i]][height.y + dy[i]] > h) {
                        queue.add(Point(height.x + dx[i], height.y + dy[i]))
                    }
                    visited[height.x + dx[i]][height.y + dy[i]] = true
                }
            }
        }
    }

    data class Point(
        val x: Int,
        val y: Int
    )
}

fun main() {
    `안전 영역`().solve()
}
