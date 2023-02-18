class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        var todayDateFormat = today.split(".").map{ it.toInt() }
        var termsInfo = terms.map{ it.split(" ") }
        privacies.forEachIndexed{ idx, p ->
            var privaciesDateFormat = p.split(" ").first().split(".").map{ it.toInt() } 
            val type = p.split(" ").last()
            val date = (todayDateFormat[0] - privaciesDateFormat[0]) * 12 * 28 +
            (todayDateFormat[1] - privaciesDateFormat[1]) * 28 +
            (todayDateFormat[2] - privaciesDateFormat[2]) 
            
            // println("${termsInfo.find{ it[0] == type }}")
            
            if (termsInfo.find{ it[0] == type}!![1].toInt() * 28 - date < 1) {
                answer.add(idx + 1)
            }
        }
        
        return answer.toIntArray()
    }
}