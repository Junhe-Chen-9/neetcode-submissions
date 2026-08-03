class LRUCache {
    class Node{
        int key;
        int val;
        Node left;
        Node right;
        public Node(){

        }
    }
    HashMap<Integer,Node> lookUpMap;
    Node list;
    Node tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        list = new Node();
        tail = new Node();
        list.right = tail;
        tail.left = list;
        lookUpMap = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if(lookUpMap.containsKey(key)){
            // move the the head
            Node node = lookUpMap.get(key);
            moveToTheHead(node);
            return node.val;
        }else{
            return -1;
        }
    }
    private void moveToTheHead(Node node){
        node.left.right = node.right;
        node.right.left = node.left;
        node.right = list.right;
        list.right.left = node;
        list.right = node;
        node.left = list;
    }
    public void put(int key, int value) {
        if(lookUpMap.containsKey(key)){
            Node node = lookUpMap.get(key);
            node.val = value;
            moveToTheHead(node);
            
        }else{
            Node node = new Node();
            node.key = key;
            node.val = value;
            node.right = list.right;
            list.right.left = node;
            list.right = node;
            node.left = list;
            lookUpMap.put(key,node);
            if(lookUpMap.size() > capacity){
                // we prune the last node
                Node prune = tail.left;
                lookUpMap.remove(prune.key);
                tail.left = prune.left;
                prune.left.right = tail;
            }
            
        }
    }
}
