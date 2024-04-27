package jimin.`60week`

import java.lang.Integer.max
import java.util.PriorityQueue

class 뮤탈리스트 {
    fun solve() {
        val n = readln().toInt()
        val healthes = readln().split(" ").map { it.toInt() } as MutableList

        repeat(3 - healthes.size) {
            healthes.add(0)
        }

        bfs(healthes[0], healthes[1], healthes[2])
    }

    fun bfs(a: Int, b: Int, c: Int) {
        val queue = ArrayDeque<MutableList<Int>>()
        queue.add(mutableListOf(a, b, c))
        val types = mutableListOf(
                mutableListOf(9, 3, 1),
                mutableListOf(9, 1, 3),
                mutableListOf(3, 9, 1),
                mutableListOf(3, 1, 9),
                mutableListOf(1, 9, 3),
                mutableListOf(1, 3, 9)
        )
        val dp = MutableList(a + 1) {
            MutableList(b + 1) {
                MutableList(c + 1) { 0 }
            }
        }
        dp[a][b][c] = 1

        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()

            if(now.all { it <= 0 }) {
                println(dp[now[0]][now[1]][now[2]] - 1)
                break
            }

            for (type in types) {
                val tmp = mutableListOf<Int>()
                for (i in 0 until 3) {
                    tmp.add(max(now[i] - type[i], 0))
                }

                if(dp[tmp[0]][tmp[1]][tmp[2]] == 0) {
                    queue.add(tmp)
                    dp[tmp[0]][tmp[1]][tmp[2]] = dp[now[0]][now[1]][now[2]] + 1
                }
            }
        }


    }
}

fun main() {
    `뮤탈리스트`().solve()
}