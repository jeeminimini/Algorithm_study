class Solution {
    fun solution(t: String, p: String): Int {
        var result = 0
        t.substring(0, t.length - p.length + 1).forEachIndexed { idx1, tt ->
            if (tt <= p.first()) {
                if (t.substring(idx1, idx1 + p.length) <= p) {
                    result += 1
                }
            }
        }
        return result
    }
}