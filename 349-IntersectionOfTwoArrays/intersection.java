// Time: O(n)  Space: O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i : nums1)
            set1.add(i);
        
        for (int j : nums2)
            if(set1.contains(j))
                intersect.add(j);
        
        int[] res = new int[intersect.size()];
        int k = 0;
        for (int j : intersect)
            res[k++] = j;
        return res;   
    }
}