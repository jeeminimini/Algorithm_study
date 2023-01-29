package jimin.`20week`

import java.lang.Math.sqrt
import kotlin.math.pow

class `별자리 만들기` {
    var n = 0
    var starInfo = mutableListOf<StarInfo>()
    lateinit var parent: MutableList<Int>
    fun solve() {
        n = readln().toInt()
        val stars = mutableListOf<Point>()
        parent = MutableList(n + 1){ it }
        repeat(n) {
            readln().split(" ").map { it.toDouble() }.apply {
                stars.add(Point(first(), last()))
            }
        }
        for (i in 0 until n - 1) for (j in i + 1 until n) {
            starInfo.add(StarInfo(sqrt((stars[i].x - stars[j].x).pow(2) + (stars[i].y - stars[j].y).pow(2)), i, j))
        }
        starInfo.sortBy{ it.distance }

        var result = 0.0
        for(star in starInfo) {
            if (find(star.x) != find(star.y)) {
                union(star.x, star.y)
                result += star.distance
            }
        }

        println(String.format("%.2f", result))
    }

    private fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    private fun union(x:Int, y: Int) {
        val xx = find(x)
        val yy = find(y)

        if (xx == yy) {
            return
        }else if (xx < yy) {
            parent[yy] = xx
        } else {
            parent[xx] = yy
        }
    }

    data class Point(
        val x: Double,
        val y: Double
    )

    data class StarInfo(
        val distance: Double,
        val x: Int,
        val y: Int
    )
}

fun main() {
    `별자리 만들기`().solve()
}