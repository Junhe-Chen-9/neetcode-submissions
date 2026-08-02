class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] s_arr = s.toCharArray();
            Arrays.sort(s_arr);
            map.putIfAbsent(String.valueOf(s_arr), new ArrayList<>());
            map.get(String.valueOf(s_arr)).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(String k : map.keySet()){
            res.add(map.get(k));
        }
        return res;
    }
}
