class Solution {
    fun solution(food: IntArray): String {
        var result = ""
        food.drop(1).forEachIndexed{ idx, n ->
            repeat(n / 2) {
                result += (idx + 1).toString()
            }
        }
        result += "0"
        result.reversed().drop(1).forEach { result += it }
        return result
    }
}