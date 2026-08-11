
class Solution {
    // Memoization map where key is "index,currentSum" and value is the number of ways
    HashMap<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(nums, target, 0, 0);
    }

    private int dp(int[] nums, int target, int i, int sum) {
        // Base case: if we reach the end of the array
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Create a unique key for the current state
        String key = i + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Choice 1: add nums[i]
        int add = dp(nums, target, i + 1, sum + nums[i]);
        
        // Choice 2: subtract nums[i]
        int subtract = dp(nums, target, i + 1, sum - nums[i]);

        // Store and return the total number of ways
        int totalWays = add + subtract;
        memo.put(key, totalWays);
        
        return totalWays;
    }
}