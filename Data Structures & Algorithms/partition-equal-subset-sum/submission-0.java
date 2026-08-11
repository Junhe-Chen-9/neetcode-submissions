class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i ++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;

        memo = new Boolean[n][sum / 2 + 1];
        return dp(nums,0,sum / 2);
    }
    private boolean dp(int[] nums, int i, int target){
        // base case 
        if(i == nums.length) return target == 0;
        if(target < 0) return false;
        // solved case
        if(memo[i][target] != null) return memo[i][target];
        return memo[i][target] = dp(nums,i + 1, target) || dp(nums,i + 1, target - nums[i]);

    }
}
