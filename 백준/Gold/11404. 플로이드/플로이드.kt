package jimin

import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedReader
import java.io.BufferedWriter
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val busInfo = MutableList(n) { MutableList(n) { 10000001 } }
    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        if (busInfo[a - 1][b - 1] != 0) {
            busInfo[a - 1][b - 1] = min(busInfo[a - 1][b - 1], c)
        } else {
            busInfo[a - 1][b - 1] = c
        }
    }

    for (i in 0 until n) {
        busInfo[i][i] = 0
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                busInfo[i][j] = min(busInfo[i][j], busInfo[i][k] + busInfo[k][j])
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (busInfo[i][j] == 10000001) {
                bw.write("0 ")
            } else {
                bw.write("${busInfo[i][j]} ")
            }
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}