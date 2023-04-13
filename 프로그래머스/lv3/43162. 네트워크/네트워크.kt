class Solution {
    lateinit var parents: MutableList<Int>
    fun solution(n: Int, computers: Array<IntArray>): Int {
        parents = MutableList(n) { it }
        for (i in 0 until n) {
            for (j in 0 until n){
                if (i != j) {
                    if (computers[i][j] == 1){
                        setParent(i, j)
                    }
                }
            }
        }
        repeat(n) {
            findParent(it)
        }
        
        return parents.toSet().size
    }
    
    fun findParent(x: Int): Int {
        if (x != parents[x]) {
            parents[x] = findParent(parents[x])
        }
        return parents[x]
    }
    
    fun setParent(a: Int, b: Int) {
        val aParent = findParent(a)
        val bParent = findParent(b)
        if (aParent < bParent) {
            parents[bParent] = aParent
        } else {
            parents[aParent] = bParent
        }

    }
}