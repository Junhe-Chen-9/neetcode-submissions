class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i ++){
            res += expandFromCenter(s,i,i);
            res += expandFromCenter(s,i,i + 1);
        }
        return res;
    }
    private int expandFromCenter(String s, int a, int b){
        int count = 0;
        
        while(a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)){
            count ++;
            a --;
            b ++;
        }
        return count;
    }
}
