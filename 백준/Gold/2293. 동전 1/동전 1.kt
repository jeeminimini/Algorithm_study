package jimin.`19week`

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val coins = mutableListOf<Int>()
    repeat(n) {
        coins.add(readln().toInt())
    }
    coins.sort()
    val sumList = MutableList(k + 1) { 0 }
    sumList[0] = 1
    coins.forEachIndexed { idx, coin ->
        for (i in 1..k) {
            if (i - coins[idx] >= 0) {
                sumList[i] = sumList[i] + sumList[i - coins[idx]]
            }
        }
    }
    println(sumList[k])
}