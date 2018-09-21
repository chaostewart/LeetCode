class Solution {
    public int maximumProduct(int[] nums) {
        /*
        PriorityQueue<Integer> posHeap = new PriorityQueue<>();
        PriorityQueue<Integer> negHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            posHeap.add(i);
            negHeap.add(i);
            if (posHeap.size() > 3)
                posHeap.poll();
            if (negHeap.size() > 2)
                negHeap.poll();
        }
        
        int p1 = 1, p2 = 0;
        while (!posHeap.isEmpty()) {
            p2 = posHeap.poll();
            p1 *= p2;
        }
        
        while (!negHeap.isEmpty()) {
            p2 *= negHeap.poll();
        }
            
        return Math.max(p1, p2);
        */
        // it's way faster not using heap
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if (n > max2){
                max3 = max2;
                max2 = n;
            }
            else if(n > max3)
                max3 = n;
            
            if (n < min1) {
                min2 = min1;
                min1 = n;
            }
            else if(n < min2)
                min2 = n;
        
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}