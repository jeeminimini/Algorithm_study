package jimin.`3week`

import java.io.BufferedReader
import java.io.InputStreamReader

data class GasStation(
    val roadLength: Int,
    val oilPrice: Int
)

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val infoList = ArrayList<GasStation>()
    val num = readLine().toInt()
    val length = readLine().split(" ").map { it.toInt() }.toMutableList()
    length.add(0, 0)
    val price = readLine().split(" ").map { it.toInt() }
    repeat(num) { i ->
        infoList.add(GasStation(length[i], price[i]))
    }

    var totalCharge = 0
    var nowPrice = infoList[0].oilPrice
    for (i in 1 until infoList.size){
        totalCharge += nowPrice * infoList[i].roadLength
        if (nowPrice > infoList[i].oilPrice) {
            nowPrice = infoList[i].oilPrice
        }
    }

    println(totalCharge)
}