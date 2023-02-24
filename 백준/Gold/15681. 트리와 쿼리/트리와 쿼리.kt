package jimin.`24week`

import java.io.BufferedReader
import java.io.InputStreamReader

class `트리와 쿼리` {
    lateinit var tree: MutableList<MutableList<Int>>
    lateinit var treeInfo: MutableList<Int>
    lateinit var visited: MutableList<Boolean>

    fun solve(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, r, q) = readLine().split(" ").map { it.toInt() }
        tree = MutableList(n + 1) { mutableListOf() }
        treeInfo = MutableList(n + 1) { 1 }
        visited = MutableList(n + 1) { false }

        repeat(n - 1) {
            readLine().split(" ").map { it.toInt() }.apply {
                tree[first()].add(last())
                tree[last()].add(first())
            }
        }
        visited[r] = true
        dfs(r)
        val sb = StringBuilder()
        repeat(q) {
            sb.appendLine(treeInfo[readLine().toInt()])
        }
        println(sb)
    }

    fun dfs(root: Int) {
        tree[root].forEach { t ->
            if (visited[t].not()) {
                visited[t] = true
                dfs(t)
                treeInfo[root] += treeInfo[t]
            }
        }
    }

}

fun main() {
    `트리와 쿼리`().solve()
}