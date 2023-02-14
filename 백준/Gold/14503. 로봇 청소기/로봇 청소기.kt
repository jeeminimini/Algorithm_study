package jimin.`23week`

class `이지민_로봇 청소기` {
    var n = 0
    var m = 0
    lateinit var rooms: MutableList<MutableList<Int>>
    val dx = mutableListOf(-1, 0, 1, 0)
    val dy = mutableListOf(0, 1, 0, -1)
    var result = 1

    fun solve() {
        readln().split(" ").map { it.toInt() }.apply {
            n = first()
            m = last()
        }
        var (x, y, d) = readln().split(" ").map { it.toInt() }
        x += 1
        y += 1
        rooms = MutableList(n + 2) { MutableList(m + 2) { 1 } }
        for (i in 0 until n) {
            readln().split(" ").map { it.toInt() }.forEachIndexed { j, it ->
                rooms[i + 1][j + 1] = it
            }
        }
        dfs(x, y, d)
        println(result)
    }

    fun dfs(x: Int, y: Int, d: Int) {
        rooms[x][y] = -1
        var direction = -1
        for (i in 3 downTo 0) {
            if (rooms[x + dx[(d + i) % 4]][y + dy[(d + i) % 4 % 4]] == 0) {
                direction = (d + i) % 4
                break
            }
        }
        if (direction == -1) {
            if (rooms[x + dx[(d + 2) % 4]][y + dy[(d + 2) % 4]] == -1) {
                dfs(x + dx[(d + 2) % 4], y + dy[(d + 2) % 4], d)
            } else {
                return
            }
        } else {
            result += 1
            dfs(x+ dx[direction], y + dy[direction], direction)
        }
    }
}

fun main() {
    `이지민_로봇 청소기`().solve()
}