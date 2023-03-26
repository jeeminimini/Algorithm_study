package jimin.`28week`

class `드래곤 커브` {
    val dragons = MutableList(101) { MutableList(101) { false } }
    val dx = mutableListOf(1, 0, -1, 0)
    val dy = mutableListOf(0, -1,0, 1)
    fun solve() {
        repeat(readln().toInt()) {
            var (x, y, d, g) = readln().split(" ").map { it.toInt() }
            val curves = mutableListOf(d)
            repeat(g) {
                curves.reversed().forEach {
                    curves.add((it + 1) % 4)
                }
            }
            dragons[x][y] = true
            curves.forEach {
                val num = it
                if (x + dx[num] in 0..100 && y + dy[num] in 0..100) {
                    dragons[x + dx[num]][y + dy[num]] = true
                    x += dx[num]
                    y += dy[num]
                }
            }
        }

        var result = 0
        for (i in 0 until 100) {
            for (j in 0 until 100) {
                if (dragons[i][j] && dragons[i + 1][j] && dragons[i][j + 1] && dragons[i + 1][j + 1]) {
                    result += 1
                }
            }
        }
        println(result)
    }
}

fun main() {
    `드래곤 커브`().solve()
}