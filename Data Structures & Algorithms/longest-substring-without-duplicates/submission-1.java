class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while(right < s.length()){
            char expand = s.charAt(right);
            if(map.containsKey(expand)){
                // we need to move left to left + 1 or our left is already above that point
                left = Math.max(left,map.get(expand) + 1);
            }
            // now we have a valid window 
            map.put(expand,right);
            max = Math.max(max,right - left + 1);
            right ++;
        }
        return max;
    }
}
