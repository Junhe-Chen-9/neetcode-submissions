class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{return a[0] - b[0];});
        HashMap<Integer,Integer> seen = new HashMap<>();
        for(int n : nums){
            if(seen.containsKey(n)){
                seen.put(n,seen.get(n) + 1);
            }else{
                seen.put(n,1);
            }
        }
        for(int key : seen.keySet()){
            pq.offer(new int[]{seen.get(key),key});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i ++){
            res[i] = pq.poll()[1];
        }
        return res;
        
    }
}
