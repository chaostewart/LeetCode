/*
truth table for exclusive-or (XOR)
^ | 0 1     
--+-----     
0 | 0 1   
1 | 1 0

A^B == B^A;
0^5 = 5;
*/

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums)
            res ^= i;
        return res;
    }
}