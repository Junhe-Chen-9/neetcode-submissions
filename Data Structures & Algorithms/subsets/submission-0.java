class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(), nums,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int i ){
        // base case
        res.add(new ArrayList<>(curr));

        for(int j = i; j < nums.length; j ++){
            curr.add(nums[j]);
            backtrack(res,curr,nums,j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
