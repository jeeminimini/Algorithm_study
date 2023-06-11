package jimin.`36week`

class 봄버맨 {
    private val ground = mutableListOf<MutableList<Int>>()
    private val dx = mutableListOf(0, 0, -1, 1)
    private val dy = mutableListOf(1, -1, 0, 0)
    fun solve() {
        val (r, c, n) = readln().split(" ").map { it.toInt() }

        repeat(r) {
            ground.add(readln().chunked(1).map { if (it == ".") -1 else 3 } as MutableList)
        }

        repeat(n) {
            spentTime()
            if (it != 0) {
                when (it % 2) {
                    0 -> explodeBoom(r, c)
                    1 -> putNewBoom()
                }
            }

//            ground.forEach { g ->
//                g.forEach {
//                    print(it)
//                }
//                println()
//            }
//            println("-----------")
        }

        ground.forEach { g ->
            g.forEach {
                if (it == -1) {
                    print(".")
                } else {
                    print("O")
                }
            }
            println()
        }
    }


    private fun spentTime() {
        ground.forEachIndexed { i, g ->
            g.forEachIndexed { j, it ->
                if (ground[i][j] > 0) {
                    ground[i][j] = it - 1
                }
            }
        }
    }

    private fun putNewBoom() {
        ground.forEachIndexed { i, g ->
            g.forEachIndexed { j, it ->
                if (it == -1) {
                    ground[i][j] = 3
                }
            }
        }
    }

    private fun explodeBoom(r: Int, c: Int) {
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (ground[i][j] == 0) {
                    ground[i][j] = -1
                    for (k in 0 until 4) {
                        if (i + dx[k] in 0 until r && j + dy[k] in 0 until c) {
                            if (ground[i + dx[k]][j + dy[k]] != 0) {
                                ground[i + dx[k]][j + dy[k]] = -1
                            }
                        }
                    }
                }
            }
        }
    }
}


fun main() {
    봄버맨().solve()
}