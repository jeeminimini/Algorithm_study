class Solution {
    fun solution(n: Int): Long {
        val dp = MutableList(n + 1) { 1L }
        dp[1] = 1
        for(i in 2 .. n) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567
        }
        return dp[n]
    }
}