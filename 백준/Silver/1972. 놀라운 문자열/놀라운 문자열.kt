package jimin.`4week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val strList = arrayListOf<String>()

    while (true){
        val newStr = readLine()
        if (newStr == "*") break
        strList.add(newStr)
    }
    strList.forEach { str ->
        var duplication = false
        for (i in 1 until str.length){
            val duplicationCheckList = mutableSetOf<String>()
            for (j in 0 until str.length - i){
                val word = "${str[j]}${str[j + i]}"
                if (word in duplicationCheckList) {
                    duplication = true
                    break
                } else {
                    duplicationCheckList.add(word)
                }
            }
            if (duplication) break
        }
        if (duplication) println("$str is NOT surprising.")
        else println("$str is surprising.")
    }
}