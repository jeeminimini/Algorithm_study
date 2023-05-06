class Solution {
    fun solution(sequence: IntArray, k: Int): List<Int> {
        var answer: IntArray = intArrayOf()
        var resultStart = 0
        var resultEnd = 0
        var resultLength = Int.MAX_VALUE
        var resultSum = sequence[0]
        var start = 0
        var end = 0
        
        while (start != sequence.size && end != sequence.size) {
            if (resultSum == k) {
                if (end - start < resultLength) {
                    resultStart = start
                    resultEnd = end
                    resultLength = end - start
                }
                resultSum -= sequence[start]
                start += 1
            } else if (resultSum < k) {
                end += 1
                if (end != sequence.size) {
                    resultSum += sequence[end]
                }
            } else {
                resultSum -= sequence[start]
                start += 1
            }
        }
        return listOf(resultStart, resultEnd)
    }
}