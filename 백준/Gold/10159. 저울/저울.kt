package jimin.`34week`

class 저울 {
    fun solve() {
        val n = readln().toInt()
        val m = readln().toInt()
        val weights = MutableList(n) { MutableList(n) { F } }
        repeat(m) {
            readln().split(" ").map { it.toInt() }.apply {
                weights[first() - 1][last() - 1] = H
                weights[last() - 1][first() - 1] = L
            }
        }

        repeat(n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (i != j) {
                        for (k in 0 until n) {
                            if (weights[i][j] == H) {
                                if (weights[j][k] == H) {
                                    weights[i][k] = H
                                }
                            } else if (weights[i][j] == L) {
                                if (weights[j][k] == L) {
                                    weights[i][k] = L
                                }
                            }
                        }
                    }
                }
            }
        }

        weights.forEach { weight ->
            println(weight.count { it == F } - 1)
        }
    }

    companion object {
        const val H = 1
        const val F = 0
        const val L = -1
    }
}

fun main() {
    저울().solve()
}