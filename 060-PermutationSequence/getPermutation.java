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
        for (int i = 0, j = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = j / fact;
            sb.append(nums.remove(index));
            j -= index * fact;
        }
        return sb.toString();
    }
}
