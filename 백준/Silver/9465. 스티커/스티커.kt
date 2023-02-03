package jimin.`21week`

import java.lang.Integer.max

class 스티커 {
    fun solve() {
        repeat(readln().toInt()) {
            val n = readln().toInt()
            val stickers = mutableListOf<List<Int>>()
            repeat(2) {
                stickers.add(readln().split(" ").map { it.toInt() })
            }
            val dp = MutableList(2) { MutableList(n + 1) { 0 } }
            dp[0][1] = stickers[0][0]
            dp[1][1] = stickers[1][0]
            for (i in 2..n) {
                dp[0][i] = max(dp[1][i - 1] + stickers[0][i - 1], dp[1][i - 2] + stickers[0][i - 1])
                dp[1][i] = max(dp[0][i - 1] + stickers[1][i - 1], dp[0][i - 2] + stickers[1][i - 1])
            }
            println(max(dp[0][n], dp[1][n]))
        }
    }
}

fun main() {
    스티커().solve()
}