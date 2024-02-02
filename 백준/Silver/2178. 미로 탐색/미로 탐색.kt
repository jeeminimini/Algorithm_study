package jimin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val maze = mutableListOf<List<Int>>()
    repeat(n) {
        maze.add(br.readLine().chunked(1).map { it.toInt() })
    }

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(Pair(0, 0))

    val visited = MutableList(n) { MutableList(m) { 0 } }
    visited[0][0] = 1

    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)


    while (queue.isNotEmpty()) {
        val (nx, ny) = queue.removeFirst()
        for (i in 0 until 4) {
            if (nx + dx[i] in 0 until n && ny + dy[i] in 0 until m &&
                    maze[nx + dx[i]][ny + dy[i]] == 1 && visited[nx + dx[i]][ny + dy[i]] == 0 ) {
                queue.add(Pair(nx + dx[i], ny + dy[i]))
                visited[nx + dx[i]][ny + dy[i]] = visited[nx][ny] + 1
            }
        }
    }

    bw.write(visited[n - 1][m - 1].toString())

    bw.flush()
    bw.close()


}