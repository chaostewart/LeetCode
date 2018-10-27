/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// time complextity: O(nlogn)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        for (Interval i: intervals) {
            // insert i to previous room
            if (i.start >= pq.peek()) {  
                pq.poll();
                pq.add(i.end);
            }
            // create a new room for i
            else
                pq.add(i.end);
        }
        return pq.size(); 
    }
}
