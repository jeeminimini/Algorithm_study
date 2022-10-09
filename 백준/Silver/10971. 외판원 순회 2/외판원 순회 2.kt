package jimin.`4week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

val priceList = mutableListOf<MutableList<Int>>()
var minPrice = Int.MAX_VALUE
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {

    val checkList = mutableListOf<Boolean>()
    val num = readLine().toInt()
    repeat(num) {
        priceList.add(readLine().split(" ").map { it.toInt() }.toMutableList())
        checkList.add(false)
    }

    for (i in 0 until num) {
        //println("<$i>")
        pickNum(checkList.toMutableList(), i, 0, i)
    }

    println(minPrice)

}

fun pickNum(checkList: MutableList<Boolean>, index: Int, price: Int, firstIndex: Int) {
    checkList[index] = true

    checkList.forEachIndexed { idx, check ->
        if (check.not() && priceList[index][idx] != 0) {
            //println("index:$index idx:$idx checkList:$checkList price:$price next:${priceList[index][idx]}")
            pickNum(checkList.toMutableList(), idx, price + priceList[index][idx], firstIndex)
        }
    }

    if (checkList.all { it } && priceList[index][firstIndex] != 0) {
        //println("all true - price:${price + priceList[index][firstIndex]} minPrice:$minPrice")
        minPrice = min(price + priceList[index][firstIndex], minPrice)
    }
}