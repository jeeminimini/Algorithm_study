package jimin.`18week`

import kotlin.math.pow

fun main() {
    var (n, r, c) = readln().split(" ").map { it.toInt() }
    var result = 0
    for (i in n downTo 2) {
        val unit = 2.0.pow(i - 1).toInt()
        result += checkPosition(r / unit, c / unit) * unit * unit
        r %= unit
        c %= unit
    }
    result += checkPosition(r, c)
    println(result)
}

fun checkPosition(r: Int, c: Int): Int {
    if (r % 2 == 0 && c % 2 == 0) {
        return 0
    } else if (r % 2 == 0 && c % 2 == 1) {
        return 1
    } else if (r % 2 == 1 && c % 2 == 0) {
        return 2
    } else {
        return 3
    }
}