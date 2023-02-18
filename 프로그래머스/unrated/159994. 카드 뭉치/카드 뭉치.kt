class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val c1 = cards1.toMutableList()
        val c2 = cards2.toMutableList()
        
        goal.forEach {
            if (c1.isNotEmpty() && it == c1.first()) {
                c1.removeFirst()
            } else if (c2.isNotEmpty() && it == c2.first()) {
                c2.removeFirst()
            } else {
                return "No"
            }
        }
        return "Yes"
    }
}