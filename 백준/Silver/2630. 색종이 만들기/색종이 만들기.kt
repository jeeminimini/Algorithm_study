package jimin.`8week`

import java.io.BufferedReader
import java.io.InputStreamReader

val paperList = mutableListOf<MutableList<Int>>()
var white = 0
var blue = 0
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n) {
        paperList.add(readLine().split(" ").map { it.toInt() } as MutableList<Int>)
    }
    checkPaper(0, n, 0, n)
    println(white)
    println(blue)
}

fun checkPaper(startX: Int, endX: Int, startY: Int, endY: Int) {
    var count = 0
    for (i in startX until endX) {
        for (j in startY until endY) {
            if (paperList[i][j] == 1) {
                count += 1
            }
        }
    }
    if (count == 0) {
        white += 1
    } else if (count == (endX - startX) * (endY - startY)) {
        blue += 1
    } else {
        checkPaper(startX, (startX + endX) / 2, startY, (startY + endY) / 2)
        checkPaper((startX + endX) / 2, endX, (startY + endY) / 2, endY)
        checkPaper((startX + endX) / 2, endX, startY, (startY + endY) / 2)
        checkPaper(startX, (startX + endX) / 2, (startY + endY) / 2, endY)
    }
}