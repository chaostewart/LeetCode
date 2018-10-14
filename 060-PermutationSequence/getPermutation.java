// Time: O(n), space: O(n)
class Solution {
    public String getPermutation(int n, int k) {       
        ArrayList<Integer> nums = new ArrayList<>();       
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            nums.add(i);
        }
        // nums = {1,2,3,...,n},fact = n!
        
        // https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
        StringBuilder sb = new StringBuilder();
        int r = k - 1;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = r / fact;
            sb.append(nums.remove(index));
            r -= index * fact;
        }
        return sb.toString();
    }
}
