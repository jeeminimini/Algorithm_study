class Solution {
    var result = 0
    fun solution(number: IntArray): Int {
        combination(mutableListOf<Int>(), number, 0)
        return result
    }
    
    fun combination (threes: MutableList<Int>, number: IntArray, n: Int) {
        if (threes.size == 3) {
            if (threes.sumBy{ number[it] } == 0) {
                result += 1 
            }
            return
        }
        for(i in n until number.size) {
            if (i !in threes) {
                combination(threes.plus(i) as MutableList, number, i + 1)
            }
        }
    }
}