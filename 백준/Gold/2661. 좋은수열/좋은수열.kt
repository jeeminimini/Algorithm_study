package jimin.`24week`

import kotlin.system.exitProcess

class 좋은수열 {
    val numbers = mutableListOf("1", "2", "3")
    var n = 0
    fun solve() {
        n = readln().toInt()
        makeNumber(StringBuilder())
        //println(result.toString())
    }

    fun makeNumber(num: StringBuilder) {
        if (num.length == n) {
            println(num)
            //result = if (result.toString() <= num.toString()) result else num
            exitProcess(0)
        }
        numbers.forEach {
            if (isGood(num.toString() + it)) {
                makeNumber(StringBuilder(num.toString() + it))
            }
        }
    }

    fun isGood(num: String): Boolean {
        for (i in 1..num.length / 2) {
            //println("num $num ${num.length - (i * 2)} ${num.length - i} ${num.length} ${num.substring(num.length - (i * 2), num.length - i)} ${num.substring(num.length - i, num.length)}")
            if (num.substring(num.length - (i * 2), num.length - i) == num.substring(num.length - i, num.length)) {
                //println("같다!")
                return false
            }
        }
        return true
    }
}

fun main() {
    좋은수열().solve()
}