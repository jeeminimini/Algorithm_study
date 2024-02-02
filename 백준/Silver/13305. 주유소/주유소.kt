package jimin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val roads = br.readLine().split(" ").map{ it.toLong() }
    val oils = br.readLine().split(" ").map{ it.toLong() }
    var cost = 0L
    var idx = 0

    while (idx < n - 1){
        if (oils[idx] >= oils[idx + 1]) {
            cost += oils[idx] * roads[idx]
            idx += 1
            //bw.write("크다 idx $idx now price ${oils[idx - 1] * roads[idx - 1]}\n")
        } else {
            val cheaper = oils[idx]
            while (idx < n - 1 && cheaper < oils[idx + 1]) {
                cost += cheaper * roads[idx]
                idx += 1
                //bw.write("작다1 idx $idx now price ${cheaper * roads[idx - 1]} cheaper $cheaper \n")
            }
            if (idx < n - 1) {
                cost += cheaper * roads[idx]
                idx += 1
            }
            //bw.write("작다2 idx $idx now price ${cheaper * roads[idx - 1]} cheaper $cheaper \n")

        }
        //bw.write("idx $idx cost $cost \n")
    }

    bw.write("$cost\n")

    bw.flush()
    bw.close()
}