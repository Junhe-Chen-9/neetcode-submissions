class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int n : nums) set.add(n);
        for(int n : nums){
            int streak = 0, curr = n;
            while(set.contains(curr)){
                streak ++;
                curr ++;
            }
            res = Math.max(res,streak);
        }
        return res;
    }
}
