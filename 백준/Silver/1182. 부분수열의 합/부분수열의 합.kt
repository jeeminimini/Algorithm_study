package jimin.`18week`

var n = 0
var s = 0
var result = 0
fun main() {
    readln().split(" ").map { it.toInt() }.apply {
        n = first()
        s = last()
    }
    val numbers = readln().split(" ").map { it.toInt() } as MutableList
    numbers.sort()
    getNumber(numbers, 0, 0)
    println(result)
}

fun getNumber(numbers: MutableList<Int>, idx: Int, sum: Int) {
    if (idx != 0) {
        if (sum * s <= 0 && sum > s) {
            return@getNumber
        } else if (sum == s) {
            result += 1
        }
    }

    for (i in idx until n) {
        getNumber(numbers, i + 1, sum + numbers[i])
    }
}