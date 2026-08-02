class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int runningMax = 0;
        for(int i = 0; i < nums.length; i ++){
            runningMax = Math.max(nums[i], runningMax + nums[i]);
            res = Math.max(res,runningMax);
        }
        return res;
    
    }
}
