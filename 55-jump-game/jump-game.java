import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int mx = 0;
        for(int i = 0; i < n; i++){
            if(i > mx) return false;
            mx = Math.max(mx, i + nums[i]);
        }


        return true;
    }
}