class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        citations.sortDescending()
        // println(citations.joinToString())
        for(i in 0 until citations.size) {
            if (citations[i] >= i + 1) {
                answer = i + 1
            }
        }
        return answer
    }
}