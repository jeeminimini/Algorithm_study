package jimin.`31week`

import java.lang.Integer.*

class 운동 {

    fun solve() {
        val (e, v) = readln().split(" ").map{ it.toInt() }
        val roadInfo = MutableList(e){ MutableList(e){ INF } }
        repeat(v) {
            val (a, b, c) = readln().split(" ").map{ it.toInt() }
            roadInfo[a - 1][b - 1] = c
        }

        for(i in 0 until e) {
            for (j in 0 until e){
                for (k in 0 until e) {
                    if (roadInfo[j][i] != INF && roadInfo[i][k] != INF) {
                        roadInfo[j][k] = min(roadInfo[j][k], roadInfo[j][i] + roadInfo[i][k])
                    }
                }
            }
        }

        var mini = INF

        for (i in 0 until e) {
            for (j in 0 until e) {
                if (roadInfo[i][j] != INF && roadInfo[j][i] != INF) {
                    mini = min(mini, roadInfo[i][j] + roadInfo[j][i])
                }
            }
        }
        if (mini == INF) {
            println(-1)
        } else {
            println(mini)
        }
    }

    companion object{
        const val INF = Int.MAX_VALUE
    }
}

fun main() {
    운동().solve()
}