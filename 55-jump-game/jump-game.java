class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[10005];
        dp[0] = true;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(!dp[i]) return false;
            for(int j = 0; j <= nums[i]; j++){
                if(i + j >= n) break;
                dp[i + j] = true;
            }
        }

        return dp[n-1];
    }
}