class Solution {
    fun solution(s: String): Int {
        var first = s.first()
        var same = 0
        var diff = 0
        var answer = 0
        s.forEachIndexed{ idx, it ->
            if (first == '0') {
                first = it
            } 
            if (it == first) {
                same += 1
            } else {
                diff += 1
            }
            if (same == diff) {
                answer += 1
                first = '0'
                same = 0
                diff = 0
            }
        }
        if (same != 0 || diff != 0) {
            answer += 1
        }
        return answer
    }
}