class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        var standard = mutableListOf<String>("aya", "ye", "woo", "ma")
        babbling.forEach{ 
            var b = it
            var duplication = ""
            while (b.length > 1) {
                if (b.length >= 2 && b.substring(0, 2) != duplication && b.substring(0, 2) in standard) {
                    duplication = b.substring(0, 2)
                    b = b.drop(2)
                } else if (b.length >= 3 && b.substring(0, 3) != duplication && b.substring(0,3) in standard){
                    duplication = b.substring(0, 3)
                    b = b.drop(3)
                } else {
                    break
                }
            }
            
            if (b.length == 0) {
                answer += 1
            }
            
        }
        return answer
    }
}