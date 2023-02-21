class Solution {
    fun solution(s: String): String {
        var answer = ""
        var start = true
        s.chunked(1).forEach{
            if(start) {
                start = false
                answer += it.toUpperCase()
            } else {
                answer += it.toLowerCase()
            }
            if (it == " "){
                start = true
            }
        }
        return answer
    }
}