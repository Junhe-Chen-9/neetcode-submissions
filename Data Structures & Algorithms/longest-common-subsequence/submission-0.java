class Solution {
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return dp(text1,text2,0,0);
    }
    private int dp(String s1, String s2,int p1, int p2){
        // base case 
        int l1 = s1.length();
        int l2 = s2.length();
        if(p1 >= l1 || p2 >= l2) return 0;

        // solved case
        if(memo[p1][p2] != null) return memo[p1][p2];

        // solve the case 
        int res = 0;
        char c1 = s1.charAt(p1);
        char c2 = s2.charAt(p2);
        if(c1 == c2){
            // we can try it out either take this as common subsequence or not 
            res = dp(s1,s2,p1 + 1, p2 + 1) + 1;
        }
        // we can skip this character from text1 or text 2
        res = Math.max(res, Math.max(dp(s1,s2,p1 + 1,p2), dp(s1,s2,p1,p2 + 1)));
        return memo[p1][p2] = res;
    }
}
