class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        for(int i = 0; i < wordList.size(); i ++){
            for(int j = i + 1; j < wordList.size(); j ++){
                String word = wordList.get(i);
                String next = wordList.get(j);
                if(word.equals(next)) continue;
                if(canTransform(word,next)){
                    graph.putIfAbsent(word,new ArrayList<>());
                    graph.putIfAbsent(next,new ArrayList<>());
                    graph.get(word).add(next);
                    graph.get(next).add(word);
                }
            }
        }
        
        // PriorityQueue<String[]> pq = new PriorityQueue<>((a,b) -> {return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);});
        Queue<String> pq = new LinkedList<>();
        pq.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int res = 1;
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i = 0; i < size; i ++){
                String key = pq.poll();
            
                if(key.equals(endWord)) return res;
                // keep process

                if(!graph.containsKey(key)) continue;
                for(String next: graph.get(key)){
                    if(visited.contains(next)) continue;
                    // explore from here
                    pq.add(next);
                    visited.add(next);
                }
            }
            res ++;
        }
        return 0;
    }
    private boolean canTransform(String a, String b){
        if(a.length() != b.length()) return false;
        int diff = 0;
        for(int i = 0; i < a.length(); i ++){
            if(a.charAt(i) != b.charAt(i)) diff ++;
        }
        return diff <= 1;
    }   

}