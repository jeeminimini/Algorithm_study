import java.util.*

class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = PriorityQueue<Int>()
        var result = arrayListOf<Int>()
        score.forEach{
            if (answer.size == k ) {
                if (answer.peek() < it) {
                    answer.remove()
                    answer.add(it)
                }
            } else {
                answer.add(it)
            }
            result.add(answer.peek())
        }
        
        return result.toIntArray()
    }
}