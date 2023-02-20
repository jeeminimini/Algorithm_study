import java.lang.Integer.*
class Solution {
    var result = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        dfs(listOf<Int>(), dungeons, 0, k)
        return result
        
    }
    
    fun dfs(visited: List<Int>, dungeons: Array<IntArray>, num: Int, now: Int) {
        var over = true
        for (i in 0 until dungeons.size) {
            if (now >= dungeons[i].first() && i !in visited) {
                over = false
                dfs(visited.plus(i), dungeons, num + 1, now - dungeons[i].last())
            }
        }
        
        if (over) {
            result = max(result, num)
            return
        }
    }
}