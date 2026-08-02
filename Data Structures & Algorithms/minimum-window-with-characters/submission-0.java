class Solution {
    public String minWindow(String s, String t) {
        // sliding window
        HashMap<Character,Integer> requirement = new HashMap<>();
        for(char c : t.toCharArray()){
            requirement.putIfAbsent(c,0);
            requirement.put(c,requirement.get(c) + 1);
        }
        int reqCount = requirement.size();
        int p0 = 0;
        int p1 = 0;
        String res = "";
        int resL = Integer.MAX_VALUE;
        while(p1 < s.length()){
            // we can continue expand
            char expandingCharacter = s.charAt(p1);
            if(requirement.containsKey(expandingCharacter)){
                requirement.put(expandingCharacter,requirement.get(expandingCharacter) - 1);
                if(requirement.get(expandingCharacter) == 0){
                    reqCount --;
                }
            }
            p1 ++;
            while(reqCount == 0 && p0 < p1){
                if(p1 - p0 + 1 < resL){
                    resL = p1 - p0 + 1;
                    res = s.substring(p0,p1);
                }
                char shrinkingCharacter = s.charAt(p0);
                if(requirement.containsKey(shrinkingCharacter)){
                    requirement.put(shrinkingCharacter,requirement.get(shrinkingCharacter) + 1);
                    if(requirement.get(shrinkingCharacter) == 1){
                        reqCount ++;
                    }
                }
                p0 ++;
            }
        }
        return res;
    }
}
