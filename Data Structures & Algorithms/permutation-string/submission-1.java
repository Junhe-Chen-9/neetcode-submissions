class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[100];
        int[] count2 = new int[100];
        for(char c : s1.toCharArray()){
            count1[c - 'a'] ++;
        }
        for(int i = 0; i < s1.length() - 1; i ++){
            char c = s2.charAt(i);
            count2[c - 'a']++;
        }
        for(int i = s1.length() - 1; i < s2.length(); i ++){
            if(isValid(count1,count2)) return true;
            char c = s2.charAt(i);
            count2[c - 'a'] ++;
            if(isValid(count1,count2)) return true;
            // remove first
            char remove = s2.charAt(i - s1.length() + 1);
            count2[remove - 'a'] --;
        }
        return false;
    }
    private boolean isValid(int[] count1,int []count2){
        for(int i =0 ;i < 100; i ++){
            if(count1[i] != count2[i]) return false;
        }
        return true;
    }
}
