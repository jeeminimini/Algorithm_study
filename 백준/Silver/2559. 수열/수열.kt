package jimin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = br.readLine().split(" ").map{ it.toInt() }
    val numbers = br.readLine().split(" ").map{ it.toInt() }

    var sumi = numbers.take(k).sum()
    var front = 0
    var maxi = numbers.take(k).sum()
    for(back in k until n) {
        maxi = max(maxi, sumi - numbers[front] + numbers[back])
        sumi = sumi - numbers[front] + numbers[back]
        front += 1
    }
    
    bw.write(maxi.toString())

    bw.flush()
    bw.close()
}