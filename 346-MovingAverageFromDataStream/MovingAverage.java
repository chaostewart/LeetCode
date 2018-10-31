class MovingAverage {
    private int[] cq;
    private int i, count;
    private double sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        cq = new int[size];
        i = 0;
        count = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (count < cq.length)  
            count++;
        sum -= cq[i];
        sum += val;
        cq[i] = val;
        i = (i + 1) % cq.length;
        
        return sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */