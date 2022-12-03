package jimin.`12week`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, w, l) = readLine().split(" ").map { it.toInt() }
    val tracks = readLine().split(" ").map { it.toInt() }.toMutableList()
    val bridge = MutableList(w) { 0 }

    var time = 1
    var next = 1
    bridge[w - 1] = tracks.first()
    while (bridge.sum() != 0) {
        bridge.removeFirst()
       // println("sum ${bridge.sum() + tracks[next]} $l")
        if (next < n && bridge.sum() + tracks[next] <= l) {
            bridge.add(tracks[next])
            next += 1
            time += 1
            continue
        }
        bridge.add(0)
        time += 1
        //println("time $time next $next bridge $bridge")
    }
    println(time)
}
