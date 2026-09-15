import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        int maxin = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxin < i){
                return false;
            }
            maxin = Math.max(maxin, i + nums[i]);
        }

        return true;
    }
}