package jimin.`27week`

import java.lang.Math.abs
import java.lang.Math.min

class `팰린드롬?` {
    fun solve() {
        val n = readln().toInt()
        val boards = readln().split(" ").map { it.toInt() }
        val dp = MutableList(n) { MutableList(n) { 0 } }
        dp[0] = MutableList(n) { 1 }

        for(i in 1 until n) {
            for(j in 0 until n) {
                if (i == 1) {
                    if (j < n - 1 && boards[j] == boards[j + 1]) {
                        dp[i][j] = 1
                    }
                } else if (j + i < n && dp[i - 2][j + 1] == 1 && boards[j] == boards[j + i]) {
                    dp[i][j] = 1
                }
            }
        }
        val strBuilder = StringBuilder()

        repeat(readln().toInt()) {
            val (s, e) = readln().split(" ").map { it.toInt() }
            strBuilder.append(dp[abs(s - e)][min(s, e) - 1])
            strBuilder.append("\n")
        }
        print(strBuilder)
    }
}

fun main() {
    `팰린드롬?`().solve()
}