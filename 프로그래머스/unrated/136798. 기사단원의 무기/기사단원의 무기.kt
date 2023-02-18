import kotlin.math.*

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        
        repeat(number) {
            var num = getDivisor(it + 1)
            if (num > limit) {
                answer += power
            } else {
                answer += num
            }
        }
        
        
        return answer
    }
    
    fun getDivisor(num: Int): Int{
        var result = 0
        for(i in 1 .. sqrt(num.toDouble()).toInt()) {
            if(num % i == 0) {
                if (num / i == i) {
                    result += 1
                } else {
                    result += 2
                }
            }
        }
        return result
    }
}