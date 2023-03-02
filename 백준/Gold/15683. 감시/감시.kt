package jimin.`25week`

import java.lang.Integer.*

class 감시 {
    val dx = mutableListOf(-1, 0, 1, 0)
    val dy = mutableListOf(0, 1, 0, -1)
    val cctvs = mutableListOf<Pair<Int, Int>>()
    var result = Int.MAX_VALUE
    fun solve() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val office = MutableList(n + 2) { MutableList(m + 2) { 6 } }
        for (i in 0 until n) {
            readln().split(" ").map { it.toInt() }.forEachIndexed { j, it ->
                office[i + 1][j + 1] = it
            }
        }

        for (i in 1 .. n) {
            for (j in 1 .. m) {
                if (office[i][j] in 1..5) {
                    cctvs.add(Pair(i, j))
                }
            }
        }
        dfs(0, office)
        println(result)
    }

    fun dfs(cctvIdx: Int, originOffice: MutableList<MutableList<Int>>) {
        if (cctvIdx == cctvs.size) {
            var sum = 0
            originOffice.forEach{
                sum += it.count{ it == 0 }
            }
            result = min(result, sum)
            return@dfs
        }
        val cctv = cctvs[cctvIdx]
        var office = originOffice.deepCopy()
        when (office[cctv.first][cctv.second]) {
            1 -> {
                for (i in 0 until 4) {
                    var num = 1
                    while (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] != 6) {
                        if (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] == 0) {
                            office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] = -1
                        }
                        num += 1
                    }
                    dfs(cctvIdx + 1, office)
                    office = originOffice.deepCopy()
                }
            }
            2 -> {
                for (i in 0 until 2) {
                    var num = 1
                    while (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] != 6) {
                        if (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] == 0) {
                            office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] = -1
                        }
                        num += 1
                    }
                    num = 1
                    while (office[cctv.first + dx[i + 2] * num][cctv.second + dy[i + 2] * num] != 6) {
                        if (office[cctv.first + dx[i + 2] * num][cctv.second + dy[i + 2] * num] == 0) {
                            office[cctv.first + dx[i + 2] * num][cctv.second + dy[i + 2] * num] = -1
                        }
                        num += 1
                    }
                    dfs(cctvIdx + 1, office)
                    office = originOffice.deepCopy()
                }
            }

            3 -> {
                for (i in 0 until 4) {
                    var num = 1
                    while (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] != 6) {
                        if (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] == 0) {
                            office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] = -1
                        }
                        num += 1
                    }
                    num = 1
                    while (office[cctv.first + dx[(i + 1) % 4] * num][cctv.second + dy[(i + 1) % 4] * num] != 6) {
                        if (office[cctv.first + dx[(i + 1) % 4] * num][cctv.second + dy[(i + 1) % 4] * num] == 0) {
                            office[cctv.first + dx[(i + 1) % 4] * num][cctv.second + dy[(i + 1) % 4] * num] = -1
                        }
                        num += 1
                    }
                    dfs(cctvIdx + 1, office)
                    office = originOffice.deepCopy()
                }
            }

            4 -> {
                for (i in 0 until 4) {
                    var num = 1
                    while (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] != 6) {
                        if (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] == 0) {
                            office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] = -1
                        }
                        num += 1
                    }
                    num = 1
                    while (office[cctv.first + dx[(i + 1) % 4] * num][cctv.second + dy[(i + 1) % 4] * num] != 6) {
                        if (office[cctv.first + dx[(i + 1) % 4] * num][cctv.second + dy[(i + 1) % 4] * num] == 0) {
                            office[cctv.first + dx[(i + 1) % 4] * num][cctv.second + dy[(i + 1) % 4] * num] = -1
                        }
                        num += 1
                    }
                    num = 1
                    while (office[cctv.first + dx[(i + 2) % 4] * num][cctv.second + dy[(i + 2) % 4] * num] != 6) {
                        if (office[cctv.first + dx[(i + 2) % 4] * num][cctv.second + dy[(i + 2) % 4] * num] == 0) {
                            office[cctv.first + dx[(i + 2) % 4] * num][cctv.second + dy[(i + 2) % 4] * num] = -1
                        }
                        num += 1
                    }
                    dfs(cctvIdx + 1, office)
                    office = originOffice.deepCopy()
                }
            }
            5 -> {
                for (i in 0 until 4) {
                    var num = 1
                    while (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] != 6) {
                        if (office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] == 0) {
                            office[cctv.first + dx[i] * num][cctv.second + dy[i] * num] = -1
                        }
                        num += 1
                    }
                }
                dfs(cctvIdx + 1, office)
            }
        }
    }

    fun MutableList<MutableList<Int>>.deepCopy(): MutableList<MutableList<Int>> {
        val new = mutableListOf<MutableList<Int>>()
        this.forEach {
            new.add(it.toMutableList())
        }
        return new
    }
}

fun main() {
    감시().solve()
}