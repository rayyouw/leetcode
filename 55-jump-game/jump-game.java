class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[10005];

        dp[0] = true;
        for(int i = 0; i < n; i++){
            if(!dp[i]) return false;
            for(int j = 1; j <= nums[i]; j++){
                if(i + j <= n-1) dp[i+j] = true;
            }
        }


        return dp[n-1];
    }
}