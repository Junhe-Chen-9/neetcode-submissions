class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        // Map to keep track of visited original nodes and their corresponding clones
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        // 1. Clone the root node and put it in the map and queue
        q.add(node);
        map.put(node, new Node(node.val));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            // Iterate through all neighbors of the current original node
            for (Node neighbor : curr.neighbors) {
                // If the neighbor hasn't been cloned yet, create its clone and add to queue
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                
                // Connect the clone of the current node to the clone of the neighbor
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        
        // Return the clone of the starting node
        return map.get(node);
    }
}