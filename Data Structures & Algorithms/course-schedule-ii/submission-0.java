class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.putIfAbsent(b,new ArrayList<>());
            indegree[a] ++;
            graph.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i ++){
            int degree = indegree[i];
            if(degree == 0) q.add(i);
        }
        List<Integer> path = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i ++){
                int curr = q.poll();
                path.add(curr);
                if(!graph.containsKey(curr)) continue;
                for(int next : graph.get(curr)){
                    indegree[next] --;
                    if(indegree[next] == 0){
                        q.add(next);
                    }
                }
            }
        }
        if(path.size() == numCourses){
            int[] res = new int[numCourses];
            for(int i = 0; i < res.length; i ++){
                res[i] = path.get(i);
            }
            return res;
        }
        return new int[]{};
    }
}
