import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[10005];
        int[] c = new int[10005];
        c[n-1] = 1;
        Arrays.fill(dp, 100000);
        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            for(int j = 1; j <= nums[i]; j++){
                if(i + j < n) dp[i] = Math.min(dp[i], 1 + dp[i+j]);
            }

            System.out.println(dp[i]);
        }

        return dp[0];
    }
}

// Lakukan iterasi dari index (posisi) terakhir (n-1)
// untuk setiap iterasinya (selain iterasi index terakhir), cek semua index yang dia bisa jump kesitu. Misalkan :