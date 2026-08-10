class Solution {
    
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i ++){
            // we can expand from middle or paralle
            //aba abba
            // |   ||
            int aba = expand(s,i,i);
            int abba = expand(s,i,i + 1);
            int len = Math.max(aba,abba);
            if(len > max){
                max = len;
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1);
    }
    private int expand(String s, int a, int b){
        while(a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)){
            a --;
            b ++;
        }
        return b - a - 1;
    }
    

}
