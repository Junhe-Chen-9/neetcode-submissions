class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<>());
        return res;
    }
    private void backtrack(String s, int i, List<String> curr){
        // base case 
        if(i >= s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int end = i + 1; end <= s.length(); end ++){
            String substring = s.substring(i,end);
            if(isValid(substring)){
                curr.add(substring);
                backtrack(s,end,curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isValid(String subString){
        int left = 0, right = subString.length() - 1;
        while(left <= right){
            if(subString.charAt(left) != subString.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}
