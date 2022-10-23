package jimin.`6week`

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val masterWord = readLine()
    val masterAlphabetList = MutableList(26) { i -> 0 }
    masterWord.forEach {
        masterAlphabetList[it - 'A'] += 1
    }

    val alphabetList = MutableList(n - 1) { MutableList(26) { i -> 0 } }
    repeat(n - 1) { n ->
        val word = readLine()
        word.forEach { w ->
            alphabetList[n][w - 'A'] += 1
        }
    }
    //println("master $masterAlphabetList")
    //println("alpha $alphabetList")

    var total = 0
    repeat(n - 1) { idx ->
        var num = 0
        if (masterWord.length == alphabetList[idx].sum()) { // 같은 길이 -> 하나 바꾸기
            if (masterAlphabetList == alphabetList[idx]) {
                total += 1
            } else {
                masterAlphabetList.forEachIndexed { i, n ->
                    if (n > alphabetList[idx][i]) num += n - alphabetList[idx][i]
                    else num += alphabetList[idx][i] - n
                }
                if (num == 2) total += 1
            }
        } else if (masterWord.length == alphabetList[idx].sum() + 1) { // 후보지가 더 길음
            masterAlphabetList.forEachIndexed { i, n ->
                if (n > alphabetList[idx][i]) num += n - alphabetList[idx][i]
                else num += alphabetList[idx][i] - n

            }
            if (num == 1) total += 1
        } else {
            masterAlphabetList.forEachIndexed { i, n ->
                if (n > alphabetList[idx][i]) num += n - alphabetList[idx][i]
                else num += alphabetList[idx][i] - n
            }
            if (num == 1) total += 1
        }

    }
    println(total)


}

