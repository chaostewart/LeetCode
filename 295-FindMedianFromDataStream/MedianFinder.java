class MedianFinder {
    // create two heaps
    private Queue<Long> largeHalf = new PriorityQueue(),   // largeHalf is a min-heap
                        smallHalf = new PriorityQueue();   // smallHalf is a min-heap, but it sorts the negative of input data
                        // smallHalf can be initalized as a max-heap as the following, when doing do, change all '-' to '+'
                        //smallHalf = new PriorityQueue(Comparator.reverseOrder());
    /** initialize your data structure here.*/
    public MedianFinder() {

    }
     
    public void addNum(int num) {
        largeHalf.add((long)num);   // insert num to the large half, time: O(logn)
        smallHalf.add(-largeHalf.poll());  // remove and negate the min in the large half, insert to small half, time: O(logn)
        if (largeHalf.size() < smallHalf.size())   // make sure size of large half is larger than or equal to small half
            largeHalf.add(-smallHalf.poll());   //  time: O(logn)
    }
    
    public double findMedian() {
        // runtime of each .peek() is O(1)
        return largeHalf.size() > smallHalf.size() ? largeHalf.peek() : (largeHalf.peek() - smallHalf.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */