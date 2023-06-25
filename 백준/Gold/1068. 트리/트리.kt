package jimin.`41week`

class 트리 {
    private var leafNum = 0
    private var rootNode = -1

    fun solve() {
        val n = readln().toInt()
        val nodes = readln().split(" ").map { it.toInt() }
        val removeNode = readln().toInt()
        val tree = MutableList<MutableList<Int>>(n) { mutableListOf() }

        for (i in 0 until n) {
            if (nodes[i] != -1) {
                tree[nodes[i]].add(i)
            } else {
                rootNode = i
            }
        }

//        println(tree)
//        println(nodes)

        dfs(-1, rootNode, removeNode, tree)
        println(leafNum)
    }

    fun dfs(parent: Int, now: Int, removeNode: Int, tree: MutableList<MutableList<Int>>) {
        //println("parent $parent now $now leaf $leafNum")
        val children = tree[now]
        if (now == removeNode) {
            if(parent != -1 && tree[parent].size == 1) {
                leafNum += 1
            }
//            println("leaf $leafNum")
            return@dfs
        }
        if (children.isEmpty()) {
//            println("leaf2 $leafNum")
            leafNum += 1
        }

        children.forEach {
            dfs(now, it, removeNode, tree)
        }
    }
}

fun main() {
    트리().solve()
}