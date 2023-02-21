class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1
        var num = 2
        run {
            while(num <= n) {
                for (i in 0 until n step num) {
                    if(a - 1 in i until i + num && b - 1 in i until i + num) {
                        return@run
                    }
                }
                //println("num $num answer $answer")
                num *= 2
                answer += 1
            }
        }

        return answer
    }
}