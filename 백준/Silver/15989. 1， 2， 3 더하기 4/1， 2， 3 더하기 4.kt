package jimin.`9week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dp = MutableList(10001){ 1 }
    for (i in 2 .. 10000){
        dp[i] = dp[i] + dp[i - 2]
    }
    for (i in 3 .. 10000){
        dp[i] = dp[i] + dp[i - 3]
    }
    repeat(readLine().toInt()){
        println(dp[readLine().toInt()])
    }
}

//fun getTwo(num: Int): Int {
//    var number = num
//    var total = 1
//    while (number > 0) {
//        number -= 2
//        if (number >= 0) {
//            total += 1
//        }
//        println("2 total $total number $number")
//    }
//    return total
//}
//
//fun getThree(num: Int): Int {
//    var number = num
//    var total = getTwo(number)
//    while (number > 0) {
//        number -= 3
//        if (number > 0) {
//            total += getTwo(number)
//        }
//        println("3 total $total number $number")
//    }
//    return total
//}