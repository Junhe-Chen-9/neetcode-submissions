class Solution {
    class Node{
        int place;
        int cost;
        int stops;
        public Node(int p, int c, int s){
            this.place = p;
            this.cost = c;
            this.stops = s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<Pair<Integer,Integer>>> graph = new HashMap<>();
        for(int[] flight : flights){
            int from_i = flight[0];
            int to_i = flight[1];
            int price_i = flight[2];
            graph.putIfAbsent(from_i,new ArrayList<>());
            graph.get(from_i).add(new Pair<>(to_i,price_i));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {return a.cost - b.cost;});
        int[] stopsRecorded = new int[n];
        Arrays.fill(stopsRecorded, Integer.MAX_VALUE);
        pq.add(new Node(src,0,0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            if(curr.place == dst) return curr.cost;
            if (curr.stops >= stopsRecorded[curr.place]) {
                continue;
            }
            stopsRecorded[curr.place] = curr.stops;
            if(graph.containsKey(curr.place)){
                for(Pair<Integer,Integer> next : graph.get(curr.place)){
                    int nextCost = curr.cost + next.getValue();
                    int nextStops = curr.stops + 1;
                    int nextPlace = next.getKey();
                    if(nextStops <= k + 1 ){
                        pq.add(new Node(nextPlace,nextCost,nextStops));
                    }
                }
            }
        }
        return -1;

    }
}
