class Solution {
    public List<Integer> grayCode(int n) {
        // hmmm, not possible to come up with this solution, still don't understand how it works
        // but learnt bitwise operations from this problem, https://www.tutorialspoint.com/java/java_basic_operators.htm
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++)    // 1 << n equals 2^n
            ans.add(i ^ (i >> 1));  // ^ is bitwise XOR
        return ans;
    }
}