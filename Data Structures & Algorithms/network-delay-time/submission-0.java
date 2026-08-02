class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // single node to all distance
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<>();
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            graph.putIfAbsent(u,new HashMap<>());
            graph.get(u).put(v,t);
        }
        // dkstraj
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return a[1] - b[1];});
        int[] visited = new int[n + 1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        pq.add(new int[]{k,0});
        visited[k] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currLength = curr[1];
            if(!graph.containsKey(currNode)) continue;
            for(int next : graph.get(currNode).keySet()){
                int nextWeight = graph.get(currNode).get(next);
                if(visited[next] > currLength + nextWeight){
                    // we have a better solution for this node
                    visited[next] = currLength + nextWeight;
                    // explore from here also
                    pq.add(new int[]{next,visited[next]});
                }
            }
        }
        int res = -1;
        for(int i = 1; i < n + 1; i ++){
            int v = visited[i];
            res = Math.max(v,res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;

    }
}
