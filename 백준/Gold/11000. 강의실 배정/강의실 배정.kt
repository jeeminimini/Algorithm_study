package jimin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val classes = mutableListOf<MutableList<Int>>()
    repeat(n) {
        classes.add(br.readLine().split(" ").map { it.toInt() } as MutableList)
    }

    classes.sortWith(compareBy<MutableList<Int>> { it[0] }
            .thenBy { it[1] })

    val pq = PriorityQueue<Int>()
    pq.add(classes[0][1])

    for (i in 1 until n) {
        if (classes[i][0] >= pq.peek()) {
            pq.poll()
        }
        pq.add(classes[i][1])
    }

    bw.write(pq.size.toString())


    bw.flush()
    bw.close()


}