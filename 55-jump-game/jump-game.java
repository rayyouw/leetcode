class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            for (int step = 1; step <= nums[i] && i + step < n; step++) {
                dp[i + step] = true;
            }
        }
        
        return dp[n - 1];
    }
}