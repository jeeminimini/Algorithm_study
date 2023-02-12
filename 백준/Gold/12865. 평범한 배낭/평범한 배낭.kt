package jimin.`22week`

import java.lang.Integer.max

class `평범한 배낭` {
    fun solve() {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val products = mutableListOf(Pair(0, 0))
        repeat(n) {
            products.add(readln().split(" ").map { it.toInt() }.run {
                Pair(first(), last())
            })
        }

        val values = MutableList(n + 1) { MutableList(k + 1) { 0 } }
        for (i in 1..n) {
            for (j in 1..k) {
                if (j < products[i].first) {
                    values[i][j] = values[i - 1][j]
                } else {
                    values[i][j] = max(values[i - 1][j], values[i - 1][j - products[i].first] + products[i].second)
                }
            }
        }

        println(values[n][k])
    }
}


fun main() {
    `평범한 배낭`().solve()
}