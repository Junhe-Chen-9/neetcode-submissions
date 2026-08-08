class Solution {
    private Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        
        return dp(s,wordDict,0);
    }
    private boolean dp(String s, List<String> wordDict, int p){
        // base case 
        if(p == s.length()) return true; // we there 
        // solved case
        if(memo.containsKey(p)) return memo.get(p);
        // now we solve the problem 
        for(String w : wordDict){
            if(p + w.length() <= s.length() && s.substring(p,p + w.length()).equals(w)){
                // we can use this word
                if(dp(s,wordDict,p + w.length())){
                    memo.put(p,true);
                    return true;
                }
            }
        }
        memo.put(p,false);
        return false;
    }
}
