import java.util.*;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+5];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = costs[0] + 1;
        // System.out.println(0 + " : " + dp[0]);
        // System.out.println(1 + " : " + dp[1]);
        for(int i = 2; i <= n; i++){
            if(i-1 >= 0) dp[i] = Math.min(dp[i], dp[i-1] + costs[i-1] + 1);
            if(i-2 >= 0) dp[i] = Math.min(dp[i], dp[i-2] + costs[i-1] + 4);
            if(i-3 >= 0) dp[i] = Math.min(dp[i], dp[i-3] + costs[i-1] + 9);
            // System.out.println(i + " : " + dp[i]);
        }

        return dp[n];
    }
}