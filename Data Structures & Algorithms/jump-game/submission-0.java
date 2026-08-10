class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length + 1];
        return dp(nums,0,memo);
    }
    private boolean dp(int[] nums, int i, Boolean[] memo){
        // base case 
        if(i >= nums.length - 1) return true;
        if(nums[i] == 0) return false;

        // solved case 
        if(memo[i] != null) return memo[i];
        // solve the problem
        
        for(int next = i + 1; next <= i + nums[i]; next ++){
            if(dp(nums,next,memo)){
                return memo[i] = true;
            }
        }
        return memo[i] = false;
    }
}
