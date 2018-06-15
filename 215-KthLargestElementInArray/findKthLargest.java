class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Slow sol1: i came up with this solution because i just learnt how to implement P.Q. ....
        // O(Nlgk) running time + O(k) memory
        /* 
        PriorityQueue<Integer> heap = new PriorityQueue<>();  // Natural order so don't need (num1, num2) -> num1 - num2 
        for (int i: nums) {
            heap.offer(i);
            if (heap.size() > k) 
                heap.poll();
        }
        return heap.poll();
         */
        // Fast sol2: O(N lg N) running time + O(1) memory
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}