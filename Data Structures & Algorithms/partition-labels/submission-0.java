class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> lastSeen = new HashMap<>();
        for(int i = 0; i < s.length(); i ++ ){
            lastSeen.put(s.charAt(i),i);
        }
        List<Integer> res = new ArrayList<>();
        // now we have stored the last seen character at 
        // that is the smallest string we will need it be at
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            int end = lastSeen.get(c);
            int start = i;
            // now we can iterate the string see if we can end at the end point
            while(i <= end){
                // we going to iterate until we can come to this end 
                end = Math.max(end,lastSeen.get(s.charAt(i)));
                i ++;
            }
            // now we are at a valid end 
            res.add(end - start + 1);
        }
        return res;
    }
}
