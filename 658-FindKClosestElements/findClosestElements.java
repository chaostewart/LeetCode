class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {                                                         
        //-------- Main idea behind the binary search algorithm ----------//
        // 1) res will be a consecutive subarray of size k
        // 2) say if we need to pick 4 elems, now we are looking at 5 elem: n1, n2, n3, n4, n5
        //    we need to compare two ends: diff(x, n1) and diff(x, n5), the number with bigger diff on the end will be eleminated
        //----------------------------------------------------------------//
        // lo and hi: range of all possible start of subarray with size k + 1, so we could compare both ends
        int lo = 0, hi = arr.length - k - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // for subarray starting at mid with size k+1, we compare element at two ends to eliminate the loser
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k]))
                lo = mid + 1; // arr[mid] is the one further away from x, eliminate range[lo, mid]
            else
                hi = mid - 1; // arr[mid+k] is the one further away, all [mid, hi] will have simiar situation, elimiate them  
        }   
        /* // the following code also works
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (Math.abs(arr[mid + k] - x) < Math.abs(arr[mid] - x)) 
                lo = mid + 1;
            else 
                hi = mid;
        }
        */
        // return subarray
        List<Integer> res = new ArrayList(k);
        for (int i = 0; i < k; i++) 
            res.add(arr[lo + i]);
        
        return res;
    }
}
