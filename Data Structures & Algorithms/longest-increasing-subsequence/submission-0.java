class Solution {
    public int lengthOfLIS(int[] nums) {
        // sub problem 
        // the longest subsequence of k numbers
        // base case
        int[] dp = new int[nums.length];
        // the smallest is always the single number which is 1
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[j] < nums[i]){
                    // we can take 1 + the longest since dp[j] th position since we can append this item on top of it
                    // or we can not take that array and append one 
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }
        int res = 0;
        for(int l : dp){
            res = Math.max(res,l);
        }
        return res;
    }
}
