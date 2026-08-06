class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {return b - a;});
        for(int s : stones) pq.add(s);
        while(pq.size()>= 2){
            int x = pq.poll();
            int y = pq.poll();
            int remain = Math.abs(x - y);
            if(remain > 0) pq.add(remain);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
