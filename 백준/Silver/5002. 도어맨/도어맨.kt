package jimin.`9week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val maxDiff = readLine().toInt()
    val people = readLine().chunked(1).toMutableList()
    var man = 0
    var woman = 0
    var result = 0

    run {
        people.forEachIndexed { index, s ->
            if (man - woman >= maxDiff) {
                if (s == "M" && index + 1 < people.size && people[index + 1] == "W") {
                    people[index] = "W"
                    people[index + 1] = "M"
                    woman += 1
                } else if (s == "W"){
                    woman += 1
                } else {
                    return@run
                }
            } else if (woman - man >= maxDiff) {
                if (s == "W" && index + 1 < people.size && people[index + 1] == "M") {
                    people[index] = "M"
                    people[index + 1] = "W"
                    man += 1
                } else if (s == "M"){
                    man += 1
                } else {
                    return@run
                }
            } else {
                if (s == "M") {
                    man += 1
                } else {
                    woman += 1
                }
            }
            result += 1
            //println("man $man woman $woman result $result")
        }
    }
    println(result)

}
