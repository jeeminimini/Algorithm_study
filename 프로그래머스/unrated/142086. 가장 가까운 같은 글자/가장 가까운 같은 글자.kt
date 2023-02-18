class Solution {
    fun solution(s: String): IntArray {
        var answer = arrayListOf<Int>()
        val numbers = mutableMapOf<Char, Int>()
        s.forEachIndexed { idx, ss ->
            if (numbers[ss] == null) {
                numbers[ss] = idx
                answer.add(-1)
            } else {
                answer.add(idx - numbers[ss]!!)
                numbers[ss] = idx
            }
        }
        return answer.toIntArray()
    }
}