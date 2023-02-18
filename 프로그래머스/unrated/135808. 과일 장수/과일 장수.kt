class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        var idx = 0
        score.sortDescending()
        for (i in m - 1 until score.size step m) {
            answer += score.copyOfRange(idx, i + 1).minOf{ it } * m
            // println(score.toList().subList(idx, i + 1))
            idx = i + 1
            
        }
        return answer
    }
}