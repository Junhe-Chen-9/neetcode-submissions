class Solution {
    HashMap<Integer,Integer> parent = new HashMap<>();
    HashMap<Integer,Integer> size = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            parent.put(a,a);
            size.put(a,1);
            parent.put(b,b);
            size.put(b,1);
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(union(a,b) == 0){
                res[0] = a;
                res[1] = b;
                return res;
            }
        }
        return res;
    }
    private int find(int a){
        if(parent.get(a) == a) return a;
        int parentA = find(parent.get(a));
        parent.put(a,parentA);
        return parentA;
    }
    private int union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) return 0;

        int sizeA = size.get(parentA);
        int sizeB = size.get(parentB);

        if(sizeA >= sizeB){
            // joint b into a 
            parent.put(parentB,parentA);
            size.put(parentA,sizeA + sizeB);
        }else{
            // join a into b
            parent.put(parentA,parentB);
            size.put(parentB,sizeA + sizeB);
        }
        return 1;
    }

}
