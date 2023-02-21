class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var dp = MutableList(n + 1){ 0 }
        dp[0] = 0
        dp[1] = 1
        for(i in 2 .. n) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567
        }
        return dp[n]
    }
}