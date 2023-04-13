class Solution {
    var minValue = Int.MAX_VALUE
    
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        dfs(begin, target, words, MutableList(words.size){ false }, 0)
        return if (minValue == Int.MAX_VALUE) 0 else minValue
    }
    
    fun dfs(now: String, end: String, words: Array<String>, visited: MutableList<Boolean>, count: Int) {
        if (now == end) {
            minValue = count
            return
        }
        if (minValue < count) {
            return
        }
        for (i in 0 until words.size) {
            if (visited[i].not()) {
                var num = 0
                words[i].forEachIndexed{ j, w ->
                    if (w != now[j]) {
                        num += 1
                    }
                }

                if (num == 1) {
                    visited[i] = true
                    dfs(words[i], end, words, visited, count + 1)
                    visited[i] = false
                }
            }
            
        }
    }
}