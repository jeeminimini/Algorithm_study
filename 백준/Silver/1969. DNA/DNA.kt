package jimin.`13week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val DNAList = mutableListOf<String>()
    val alphabetList = MutableList(m) { MutableList(26) { 0 } }
    var DNA = ""
    var num = 0
    repeat(n) {
        DNAList.add(readLine())
        repeat(m) { idx ->
            alphabetList[idx][DNAList.last()[idx] - 'A'] += 1
        }
    }
    repeat(m) { idx ->
        DNA += (alphabetList[idx].indexOf(alphabetList[idx].maxOf { it }) + 'A'.code).toChar()
        num += n - alphabetList[idx].maxOf { it }
    }
    println(DNA)
    println(num)
}

