import java.util.*

class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        var stack = ArrayDeque<Int>()
        ingredient.forEach{
            stack.addFirst(it)
            if (stack.size >= 4 && stack.elementAt(0) == 1 && stack.elementAt(1) == 3 && stack.elementAt(2) == 2 && stack.elementAt(3) == 1){
                answer += 1
                repeat(4) {
                    stack.removeFirst()
                }
            }
        }
        return answer
    }
}