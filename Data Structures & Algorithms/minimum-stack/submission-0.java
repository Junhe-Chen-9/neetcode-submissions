class MinStack {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer,Integer> map = new HashMap<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.add(val);
        pq.add(val);
        map.putIfAbsent(val,0);
        map.put(val,map.get(val) + 1);
    }
    
    public void pop() {
        int val = stack.pop();
        map.put(val, map.get(val) - 1);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        while(!pq.isEmpty() && map.get(pq.peek()) <= 0){
            
            pq.poll();

        }
        return pq.isEmpty() ?  -1 : pq.peek();
    }
}
