/** Use quick select algorithm, pivot around k
    Worst-case performance: О(n^2)
    Best-case performance: О(n)
    Average performance: O(n)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect (int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];
        
        int left = start, right = end;
        int pivot = nums[(start + end)/2];
        
        while (left <= right) {
            while(left <= right && nums[left] < pivot)
                left++;
            while(left <= right && nums[right] > pivot)
                right--;
            // swap smaller number to the left of pivot, larger to the right of pivot
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; 
                right--;
            }
        }
        // at this point left > right by 1
        if (k <= right) 
            return quickSelect(nums, start, right, k);
        
        else if (k >= left) 
            return quickSelect(nums, left, end, k);
        
        return nums[k];
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Slow sol1: i came up with this solution because i just learnt how to implement P.Q. ....
        // O(Nlogk) running time + O(k) memory
        /* 
        PriorityQueue<Integer> heap = new PriorityQueue<>();  // Natural order so don't need (num1, num2) -> num1 - num2 
        for (int i: nums) {
            heap.offer(i);
            if (heap.size() > k) 
                heap.poll();
        }
        return heap.poll();
         */
        // Fast sol2: O(NlogN) running time + O(1) memory
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
