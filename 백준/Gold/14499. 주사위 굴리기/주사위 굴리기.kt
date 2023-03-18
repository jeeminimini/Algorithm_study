package jimin.`27week`

class `주사위 굴리기` {
    val maps = mutableListOf<MutableList<Int>>()
    var dice = mutableListOf(0, 0, 0, 0, 0, 0) // top, east, west, north, south, bottom
    val dx = listOf(0, 0, 0, -1, 1)
    val dy = listOf(0, 1, -1, 0, 0)

    fun solve() {
        val (n, m, x, y, k) = readln().split(" ").map { it.toInt() }
        var nowX = x
        var nowY = y
        repeat(n) {
            maps.add(readln().split(" ").map { it.toInt() } as MutableList)
        }
        readln().split(" ").map { it.toInt() }.forEach{ move ->
            if (dx[move] + nowX in 0 until n && dy[move] + nowY in 0 until m) {
                when (move) {
                    1 -> moveEast()
                    2 -> moveWest()
                    3 -> moveNorth()
                    4 -> moveSouth()
                }
                if (maps[dx[move] + nowX][dy[move] + nowY] == 0) {
                    maps[dx[move] + nowX][dy[move] + nowY] = dice[5]
                } else {
                    dice[5] = maps[dx[move] + nowX][dy[move] + nowY]
                    maps[dx[move] + nowX][dy[move] + nowY] = 0
                }
                nowX += dx[move]
                nowY += dy[move]
                println(dice.first())
            }

        }
    }

    fun moveEast() {
        val top = dice[2]
        val east = dice[0]
        val west = dice[5]
        val north = dice[3]
        val south = dice[4]
        val bottom = dice[1]
        dice = mutableListOf(top, east, west, north, south, bottom)
    }

    fun moveWest() {
        val top = dice[1]
        val east = dice[5]
        val west = dice[0]
        val north = dice[3]
        val south = dice[4]
        val bottom = dice[2]
        dice = mutableListOf(top, east, west, north, south, bottom)
    }

    fun moveNorth() {
        val top = dice[4]
        val east = dice[1]
        val west = dice[2]
        val north = dice[0]
        val south = dice[5]
        val bottom = dice[3]
        dice = mutableListOf(top, east, west, north, south, bottom)
    }

    fun moveSouth() {
        val top = dice[3]
        val east = dice[1]
        val west = dice[2]
        val north = dice[5]
        val south = dice[0]
        val bottom = dice[4]
        dice = mutableListOf(top, east, west, north, south, bottom)
    }
}

fun main() {
    `주사위 굴리기`().solve()
}