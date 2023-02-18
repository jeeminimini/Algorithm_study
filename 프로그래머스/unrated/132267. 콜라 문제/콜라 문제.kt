class Solution {
    var result = 0
    fun solution(a: Int, b: Int, n: Int): Int {
        getCoke(a, b, n)
        return result 
    }
    
    fun getCoke(a: Int, b:Int, n:Int) {
        if (n < a) {
            return
        }
        result += (n / a) * b
        println("${n/a} ${n % a}")
        getCoke(a, b, (n / a) * b + n % a)
    }
}