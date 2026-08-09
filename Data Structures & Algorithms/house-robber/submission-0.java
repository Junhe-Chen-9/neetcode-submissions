class Solution {
    Integer[] memo;
    public int rob(int[] nums) {
        memo = new Integer[nums.length  + 1];
        return dp(nums,nums.length - 1);
    }
    private int dp(int[] nums, int i){
        // base case 
        if(i < 0) return 0;
        if(i >= nums.length) return 0; // there is nothing to rub 
        // solved case
        if(memo[i] != null) return memo[i];

        
        int rub = nums[i] + dp(nums, i - 2);
        int noRub = dp(nums,i - 1);
        return memo[i] = Math.max(rub,noRub);
    }
}
