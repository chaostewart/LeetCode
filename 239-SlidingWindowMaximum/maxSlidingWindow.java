class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) 
			return new int[0];
		
		int n = nums.length;
		int[] res = new int[n - k + 1];
		// create a double-ended-queue to store indices of promising max numbers (not values)
		//Deque<Integer> deq = new ArrayDeque<>();    // OR
        LinkedList<Integer> deq = new LinkedList<>();  
        
		for (int i = 0; i < n; i++) {
			// remove index out of inspecting window of range k
			if (!deq.isEmpty() && deq.peekFirst() < i - k + 1)
				deq.pollFirst();
			// remove numbers within the inspecting window that are smaller than nums[i] 
			while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i])    // deq has the size <= k
				deq.pollLast();
			// deq stores index... res stores values
			deq.offer(i);     // insert index i to the end of queue
			if (i - k + 1 >= 0)        // start to obtain max of a sliding window at the (k-1)th number in nums
				res[i - k + 1] = nums[deq.peekFirst()];

		}
		return res;
    }
}