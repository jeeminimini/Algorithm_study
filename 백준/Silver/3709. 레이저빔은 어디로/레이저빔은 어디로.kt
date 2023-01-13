package jimin.`18week`

fun main() {
    val m = readln().toInt()
    val dx = mutableListOf(-1,0,1,0)
    val dy = mutableListOf(0,1,0,-1)
    var d = 0
    repeat(m) {
        val (n, r) = readln().split(" ").map { it.toInt() }
        val mirrors = mutableListOf<Pair<Int,Int>>()
        repeat(r) {
            readln().split(" ").map { it.toInt() }.apply{
                mirrors.add(Pair(first(), last()))
            }
        }
        val laser = readln().split(" ").map { it.toInt() }

        var x = laser[0]
        var y = laser[1]
        if (x == 0) {
            x = 1
            d = 2
        } else if (x == n + 1) {
            x = n
            d = 0
        } else if (y == 0) {
            y = 1
            d = 1
        } else if (y == n + 1) {
            y = n
            d = 3
        }
        while(x in 1 .. n && y in 1 .. n) {
            if (Pair(x, y) in mirrors) {
                d = (d + 1) % 4
            }
            x += dx[d]
            y += dy[d]
        }
        println("$x $y")
    }
}