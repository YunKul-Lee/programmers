package practice.level2.숫자_변환하기;

public class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        for(int i = x+1; i < y+1; i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            int d;

            if(isDivided(i, 2) && aboveX(x, i / 2)) a = dp[i / 2];
            if(isDivided(i, 3) && aboveX(x, i / 3)) b = dp[i / 3];
            if (aboveX(x, i - n)) c = dp[i - n];

            d = Math.min( Math.min(a, b), c);

            dp[i] = (d < Integer.MAX_VALUE) ? d + 1 : Integer.MAX_VALUE;
        }

        return dp[y] < Integer.MAX_VALUE ? dp[y] : -1;
    }

    private boolean isDivided(int num, int divide) {
        return (num / divide > 0 && num % divide == 0);
    }

    private boolean aboveX(int x, int num) {
        return (num >= x);
    }
}
