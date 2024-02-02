package jimin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val powerInfo = mutableMapOf<Long, String>()
    val powers = mutableListOf<Long>()

    repeat(n) {
        val (name, power) = br.readLine().split(" ")
        if (powerInfo.containsKey(power.toLong()).not()) {
            powerInfo[power.toLong()] = name
            powers.add(power.toLong())
        }
    }

    //bw.write("powerInfo $powerInfo $powers \n")
    repeat(m) {
        val nowPower = br.readLine().toLong()

        var first = 0
        var last = powers.size - 1
        while (first < last) {
            //bw.write("$nowPower first $first last $last \n")
            if (powers[(first + last) / 2] < nowPower) {
                first = (first + last) / 2 + 1
            } else{
                last = (first + last) / 2
            }
        }

        bw.write("${powerInfo[powers[last]]} \n")
    }

    bw.flush()
    bw.close()
}
