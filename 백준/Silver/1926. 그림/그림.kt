package jimin.`4week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

var maxNum = 0
var area = 0
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val pictureList = mutableListOf<MutableList<Int>>()
    repeat(n) {
        pictureList.add(readLine().split(" ").map { it.toInt() }.toMutableList())
    }

    var pictureNumber = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (pictureList[i][j] == 1){
                dfs(pictureList, i, j)
                pictureNumber += 1
                area = 0
            }
        }
    }
    println(pictureNumber)
    println(maxNum)
}

fun dfs(pictureList: MutableList<MutableList<Int>>, i: Int, j: Int) {
    pictureList[i][j] = 0
    area += 1
    maxNum = max(maxNum, area)
    val direction = arrayListOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
    direction.forEach {
        if (i + it.first in 0 until pictureList.size &&
            j + it.second in 0 until pictureList[0].size &&
            pictureList[i + it.first][j + it.second] == 1) {
            dfs(pictureList, i + it.first, j + it.second)
        }
    }
}

