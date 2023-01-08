package jimin.`17week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val numbers = mutableListOf<Int>()
    repeat(n) {
        numbers.add(readLine().toInt())
    }
    numbers.sort()
    var result = Int.MAX_VALUE
    repeat(n) {
        result = min(binarySearch(numbers.subList(it, n), m), result)
    }
    println(result)
}

fun binarySearch(numberList: MutableList<Int>, m: Int): Int {
    val num = numberList.first()
    var start = 0
    var end = numberList.size - 1
    var mid: Int
    var result = Int.MAX_VALUE
    while (start <= end) {
        mid = (start + end) / 2
        if (numberList[mid] - num == m) {
            result = m
            break
        } else if (numberList[mid] - num > m) {
            result = numberList[mid] - num
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return result
}