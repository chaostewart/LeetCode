class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        // sort from right to left
		while (j >= 0) {
			if(i < 0 || nums2[j] > nums1[i])    // all m numbers in nums1 has been placed OR nums2 has a bigger number
				nums1[k--] = nums2[j--];
			else
				nums1[k--] = nums1[i--];
		}
    }
}