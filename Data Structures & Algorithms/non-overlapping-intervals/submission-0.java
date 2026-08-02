class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // we want to remove the most blocking ones 
        if (intervals.length <= 1) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return a[1] - b[1];});
        for (int[] interval : intervals) {
            pq.add(interval);
        }
        int res = 0;
        int[] last = pq.poll();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(last[1] > curr[0]){
                res ++;
            }else{
                last = curr;
            }
        }
        return res;
    }
}
