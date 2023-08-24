package jimin.`42week`

import java.lang.Integer.max

class 이동하기 {
    val dx = mutableListOf(-1, 0, -1)
    val dy = mutableListOf(0, -1, -1)
    fun solve() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val maze = mutableListOf<MutableList<Int>>()
        val dp = mutableListOf<MutableList<Int>>()
        repeat(n) {
            maze.add(readln().split(" ").map { it.toInt() } as MutableList<Int>)
            dp.add(MutableList(m) { 0 })
        }

        repeat(n) { i ->
            repeat(m) { j ->
                var maxi = 0
                repeat(3) { k ->
                    if (i + dx[k] in 0 until n && j + dy[k] in 0 until m) {
                        maxi = max(dp[i + dx[k]][j + dy[k]], maxi)
                    }
                }
                dp[i][j] = maxi + maze[i][j]
            }
        }

        println(dp[n - 1][m - 1])

    }
}

fun main() {
    이동하기().solve()
}