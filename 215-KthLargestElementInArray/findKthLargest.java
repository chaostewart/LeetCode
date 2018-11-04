/** Use quick select algorithm, pivot around k
    Worst-case performance: О(n^2)
    Best-case performance: О(n)
    Average performance: O(n)
*/
// clearer quick select version
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int idx = quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
        return nums[idx];
    }

      // return the index of the kth smallest number
    int quickSelect(int[] nums, int lo, int hi, int k) {
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i] > pivot)
                swap(nums, i, --j);
            else
                i++;
        }
        swap(nums, i, hi);

        // count the nums that are <= pivot from lo
        int m = i - lo;

        // pivot is the one!
        if (m == k)     
            return i;
        // pivot is too big, so it must be on the left
        else if (m > k) 
            return quickSelect(nums, lo, i - 1, k);
        // pivot is too small, so it must be on the right
        else            
            return quickSelect(nums, i + 1, hi, k - m);
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}



class Solution {
    public int findKthLargest(int[] nums, int k) {
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
