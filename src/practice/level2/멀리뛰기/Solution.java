package practice.level2.멀리뛰기;

public class Solution {

    public long solution(int n) {
        if(n == 1) return 1L;
        if(n == 2) return 2L;

        long[] dp = new long[n + 1];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;

        for(int i=3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
