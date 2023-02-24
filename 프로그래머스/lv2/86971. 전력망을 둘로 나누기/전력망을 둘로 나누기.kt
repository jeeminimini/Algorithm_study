import kotlin.math.*

class Solution {
    lateinit var treeInfo: MutableList<Int>
    lateinit var visited: MutableList<Boolean>
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        var tree = MutableList(n + 1){ mutableListOf<Int>() }
        treeInfo = MutableList(n + 1){ 1 }
        visited = MutableList(n + 1){ false }
        wires.forEach{ w ->
            tree[w.first()].add(w.last())
            tree[w.last()].add(w.first())
        }
        visited[1] = true
        dfs(1, tree)
        return treeInfo.minOf{abs(n - it - it)}
    }
    
    fun dfs(root: Int, tree: MutableList<MutableList<Int>>) {
        tree[root].forEach{ t ->
            if (visited[t].not()){
                visited[t] = true
                dfs(t, tree)
                treeInfo[root] += treeInfo[t]
            }
        }
    }
}