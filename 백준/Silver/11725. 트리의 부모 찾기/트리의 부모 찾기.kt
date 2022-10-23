package jimin.`6week`

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var treeList = mutableMapOf<Int, MutableList<Int>>()
    repeat(n - 1) {
        val input = readLine().split(" ").map { it.toInt() }
        if (treeList[input[0]] == null) treeList[input[0]] = mutableListOf(input[1])
        else treeList[input[0]]!!.add(input[1])
        if (treeList[input[1]] == null) treeList[input[1]] = mutableListOf(input[0])
        else treeList[input[1]]!!.add(input[0])
    }


    bfs(treeList, MutableList(n + 1) { i -> false }, MutableList(n + 1) { i -> 0 })


}

fun bfs(treeList: MutableMap<Int, MutableList<Int>>, visited: MutableList<Boolean>, parent: MutableList<Int>) {
    val queue = arrayListOf<Int>()
    queue.add(1)
    visited[0] = true
    visited[1] = true
    parent[0] = 0
    parent[1] = 0

    while (queue.isNotEmpty()) {
        val v = queue.removeFirst()
        treeList[v]?.forEach {
            if (visited[it].not()){
                queue.add(it)
                visited[it] = true
                parent[it] = v
            }
        }
    }

    for (i in 2 until parent.size) {
        println(parent[i])
    }

}

