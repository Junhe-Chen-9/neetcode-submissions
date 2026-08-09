class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        for(int i = 0; i < nums.length; i ++){
            boolean[] visited = new boolean[nums.length];
            visited[i] = true;
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(nums[i]);
            permute(nums,visited,curr);
        }
        return res;
    }
    private void permute(int[] nums, boolean[] visited, List<Integer> curr){
        // base case 
        if(curr.size() == nums.length){
            List<Integer> list = new ArrayList<>(curr);
            res.add(list);
            return;
        }
        if(curr.size() >= nums.length) return;
        for(int i = 0; i < nums.length; i ++){
            if(visited[i] == false){
                // we have not used this
                visited[i] = true;
                curr.add(nums[i]);
                permute(nums,visited,curr);
                // backtrack
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }
}
