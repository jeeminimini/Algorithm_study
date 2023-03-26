package jimin.`28week`

class `미세먼지 안녕!` {
    val rooms = mutableListOf<MutableList<Int>>()
    val dx = mutableListOf(0, 0, -1, 1)
    val dy = mutableListOf(1, -1, 0, 0)

    fun solve() {
        val (r, c, t) = readln().split(" ").map { it.toInt() }
        repeat(r) {
            rooms.add(readln().split(" ").map { it.toInt() } as MutableList)
        }

        repeat(t) {
            doDirty()
            doClean()
        }
        println("${rooms.sumOf { it.sumOf { it } } + 2}")
    }

    fun doDirty() {
        val dust = MutableList(rooms.size) { MutableList(rooms.first().size) { 0 } }

        for (i in 0 until rooms.size) {
            for (j in 0 until rooms.first().size) {
                if (rooms[i][j] != 0 && rooms[i][j] != -1) {
                    var num = 0
                    val amount = rooms[i][j] / 5
                    for (k in 0 until 4) {
                        if (i + dx[k] in 0 until rooms.size && j + dy[k] in 0 until rooms.first().size && rooms[i + dx[k]][j + dy[k]] != -1) {
                            dust[i + dx[k]][j + dy[k]] += amount
                            num += 1
                        }
                    }
                    rooms[i][j] -= amount * num
                }
            }
        }

        for (i in 0 until rooms.size) {
            for (j in 0 until rooms.first().size) {
                rooms[i][j] += dust[i][j]
            }
        }

    }

    fun doClean() {
        var first = true
        for (i in 0 until rooms.size) {
            if (rooms[i][0] == -1 && first) {
                first = false
                var num = rooms[i][1]
                var tmp = 0
                for (y in 2 until rooms.first().size) {
                    tmp = rooms[i][y]
                    rooms[i][y] = num
                    num = tmp
                }
                rooms[i][1] = 0
                for (x in i - 1 downTo 0) {
                    tmp = rooms[x][rooms.first().size - 1]
                    rooms[x][rooms.first().size - 1] = num
                    num = tmp
                }
                for (y in rooms.first().size - 2 downTo 0) {
                    tmp = rooms[0][y]
                    rooms[0][y] = num
                    num = tmp
                }
                for (x in 1 until i) {
                    tmp = rooms[x][0]
                    rooms[x][0] = num
                    num = tmp
                }
            } else if (rooms[i][0] == -1 && first.not()) {
                var num = rooms[i][1]
                var tmp = 0
                for (y in 2 until rooms.first().size) {
                    tmp = rooms[i][y]
                    rooms[i][y] = num
                    num = tmp
                }
                rooms[i][1] = 0
                for (x in i + 1 until rooms.size) {
                    tmp = rooms[x][rooms.first().size - 1]
                    rooms[x][rooms.first().size - 1] = num
                    num = tmp
                }
                for (y in rooms.first().size - 2 downTo 0) {
                    tmp = rooms[rooms.size - 1][y]
                    rooms[rooms.size - 1][y] = num
                    num = tmp
                }
                for (x in rooms.size - 2 downTo i + 1) {
                    tmp = rooms[x][0]
                    rooms[x][0] = num
                    num = tmp
                }
            }
        }
    }
}

fun main() {
    `미세먼지 안녕!`().solve()
}