package jimin

import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedReader
import java.io.BufferedWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m, v) = br.readLine().split(" ").map{ it.toInt() }
    val numberInfo = MutableList(n + 1){ mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map{ it.toInt() }
        numberInfo[a].add(b)
        numberInfo[b].add(a)
    }
    numberInfo.forEach{
        it.sort()
    }

    val visited = MutableList(n + 1) { false }
    visited[v] = true
    visited[0] = true
    val result = mutableListOf<Int>()
    result.add(v)
    dfs(numberInfo, v, visited, result)

    bw.write("${result.joinToString(" ")}\n")
    bw.write("${bfs(numberInfo, v, n).joinToString(" ")}\n")

    bw.flush()
    bw.close()
}

private fun bfs(numberInfo: MutableList<MutableList<Int>>, v: Int, n:Int): MutableList<Int> {
    val visited = MutableList(n + 1) { false }
    visited[0] = true
    visited[v] = true
    val queue = ArrayDeque<Int>()
    queue.add(v)
    val result = mutableListOf<Int>()
    result.add(v)

    while (queue.isNotEmpty()) {
        val now = queue.removeFirst()
        for (num in numberInfo[now]) {
            if (visited[num].not()){
                queue.add(num)
                visited[num] = true
                result.add(num)
            }
        }
    }

    return result
}

private fun dfs(numberInfo: MutableList<MutableList<Int>>, now: Int, visited: MutableList<Boolean>, result: MutableList<Int>){
    for (num in numberInfo[now]) {
        if (visited[num].not()){
            visited[num] = true
            result.add(num)
            dfs(numberInfo, num, visited, result)
        }
    }
}