class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> seen = new HashMap<>();
        for(char task : tasks){
            seen.putIfAbsent(task,0);
            seen.put(task, seen.get(task) + 1);
        }
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((a,b) -> {return b.getValue() - a.getValue();});
        for(Character key : seen.keySet()){
            Pair<Character,Integer> pair = new Pair<>(key,seen.get(key));
            pq.add(pair);
        }
        int res = 0;
        while(!pq.isEmpty()){
            List<Pair<Character,Integer>> addBack = new ArrayList<>();
            for(int i = 0; i <= n ; i ++){
                if(pq.isEmpty()){
                    if(addBack.isEmpty()) break;
                    res ++;
                }else{
                    res ++;
                
                    Pair<Character,Integer> pair = pq.poll();
                    pair = new Pair<>(pair.getKey(), pair.getValue() - 1);
                    if(pair.getValue() > 0) addBack.add(pair);
                }
            }
            for(Pair<Character,Integer> pair : addBack) pq.add(pair);
            
        }
        return res;
    }
}
