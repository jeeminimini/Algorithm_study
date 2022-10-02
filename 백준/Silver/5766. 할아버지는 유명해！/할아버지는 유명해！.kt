

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true){
        val (n, m) = readLine().trim().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        val playerInfo = mutableMapOf<Int, Int>()
        for (i in 0 until n) {
            readLine().trim().split(" ").map {
                if (playerInfo.containsKey(it.toInt())) {
                    playerInfo[it.toInt()] = playerInfo[it.toInt()]!! + 1
                } else {
                    playerInfo.put(it.toInt(), 1)
                }
            }
        }

        var sortedPlayerInfo = playerInfo.toList().sortedBy { it.second }.reversed()
        val secondPlayer = sortedPlayerInfo.filter { sortedPlayerInfo[0].second > it.second }
        var secondPlayerList = sortedPlayerInfo.filter { it.second == secondPlayer[0].second }
        if (!secondPlayerList.isNullOrEmpty()){
            secondPlayerList = secondPlayerList.sortedBy { it.first }
            secondPlayerList.forEach { print("${it.first} ") }
        }
        println()
    }


}