class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return dp(word1,word2,0,0);
    }
    private int dp(String s1, String s2, int p1, int p2){
        // base case 
        if(p1 == s1.length() && p2 == s2.length()) return 0;
        if(p1 == s1.length()) return s2.length() - p2;
        if(p2 == s2.length()) return s1.length() - p1;

        // solved case
        if(memo[p1][p2] != null) return memo[p1][p2];
        
        // solve the case 
        char c1 = s1.charAt(p1);
        char c2 = s2.charAt(p2);
        int res = Integer.MAX_VALUE;
        if(c1 == c2){
            res = dp(s1,s2,p1 + 1, p2 + 1);
        }
        // other wise
        // we can delete 
        int d = 1 + dp(s1,s2,p1 + 1,p2);
        // we can insert
        int i = 1 + dp(s1,s2,p1,p2 + 1);
        // we can replace
        int r = 1 + dp(s1,s2,p1 + 1,p2 + 1);
        // find best operation
        int best = Math.min(d,Math.min(i,r));
        res = Math.min(res,best);
        return memo[p1][p2] = res;
    }
}
