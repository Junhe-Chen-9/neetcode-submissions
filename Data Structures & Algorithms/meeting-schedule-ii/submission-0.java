/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals,(a,b) -> {return a.start - b.start;});
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(Interval interval: intervals){
            if(!pq.isEmpty() && pq.peek() <= interval.start){
                pq.poll();
            }
            pq.add(interval.end);
        }
        return pq.size();
    }
}
