class Solution {
    fun solution(s: String): IntArray {
        var ss = s
        var time = 0
        var number = 0
        while (ss != "1") {
            getNumber(ss).apply{
                number += first
                ss = getBinary(second)
                time += 1
            }
        }
        
        return intArrayOf(time, number)
    }
    
    fun getNumber(s: String): Pair<Int, Int> {
        return Pair(s.chunked(1).count{ it == "0"}, s.chunked(1).count{ it == "1"})
    }
    
    fun getBinary(n: Int): String{
        var nn = n
        var num = ""
        while(nn > 1) {
            num += (nn % 2).toString()
            nn /= 2
        }
        return nn.toString() + num
    }
}