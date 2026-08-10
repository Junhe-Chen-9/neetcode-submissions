class MedianFinder {
    PriorityQueue<Integer> minQ = new PriorityQueue<>((a,b) -> {return b - a;});
    PriorityQueue<Integer> maxQ = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        minQ.add(num);
        if(minQ.size() - maxQ.size() > 1 || !maxQ.isEmpty() && minQ.peek() > maxQ.peek()){
            maxQ.add(minQ.poll());
        }
        if(maxQ.size() - minQ.size() > 1){
            minQ.add(maxQ.poll());
        }
    }
    
    public double findMedian() {
        if(minQ.size() == maxQ.size()){
            return (double) (maxQ.peek() + minQ.peek()) / 2;
        }else if (minQ.size() > maxQ.size()){
            return (double) minQ.peek();
        }else{
            return (double) maxQ.peek();
        }
    }
}
