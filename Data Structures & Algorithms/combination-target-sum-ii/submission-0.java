class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,candidates,target,0, new ArrayList<>());
        return res;
    }
    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int i, List<Integer> curr){
        // base case
        if(target == 0){
            // we are finished here
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if(target < 0){
            // we went too far
            return;
        }
        if(i >= candidates.length) return; // we are out of the candidate we can pick   

        // we can use this candidate to form 
        int cand = candidates[i];
        curr.add(cand);
        backtrack(res,candidates,target - cand,i + 1, curr);
        curr.remove(curr.size() - 1);
        while(i < candidates.length - 1 && candidates[i+1] == candidates[i]) i ++;
        backtrack(res,candidates,target,i + 1, curr);
        
    }
}
