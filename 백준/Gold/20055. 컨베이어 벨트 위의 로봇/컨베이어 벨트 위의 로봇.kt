package jimin.`29week`

import java.util.*

class `컨베이어 벨트 위의 로봇` {
    fun solve() {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val belts = readln().split(" ").map { it.toInt() } as MutableList
        val robots = MutableList(n * 2) { false }
        var step = 0
        while (true) {
            step++
            //1번
            Collections.rotate(belts, 1)
            Collections.rotate(robots, 1)
            if (robots[n - 1]) {
                robots[n - 1] = false
            }
            //2번
            for (i in 2 * n - 1 downTo 0) {
                if (robots[i] && robots[(i + 1) % (n * 2)].not() && belts[(i + 1) % (n * 2)] > 0) {
                    robots[i] = false
                    belts[(i + 1) % (n * 2)] -= 1
                    if ((i + 1) % (n * 2) != n - 1) {
                        robots[(i + 1) % (n * 2)] = true
                    }
                }
            }
            //3번
            if (belts.first() != 0) {
                robots[0] = true
                belts[0]--
            }
            //4번
            if (belts.count { it == 0 } >= k) {
                break
            }
        }
        println(step)
    }
}

fun main() {
    `컨베이어 벨트 위의 로봇`().solve()
}