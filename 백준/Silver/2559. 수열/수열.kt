package jimin

import kotlin.math.*

fun main() {
    val (n, k) = readLine()!!.split(" ").map{ it.toInt() }
    val numbers = readLine()!!.split(" ").map{ it.toInt() }

    var sumi = numbers.take(k).sum()
    var front = 0
    var maxi = numbers.take(k).sum()
    for(back in k until n) {
        maxi = max(maxi, sumi - numbers[front] + numbers[back])
        sumi = sumi - numbers[front] + numbers[back]
        front += 1
    }

    println(maxi)
}