public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        /*
        Integer type in Java has 32 bits and is signed. There is no unsigned int. 
        In Java int type has a cyclic representation, i.e. MAX_VALUE + 1 == Integer.MIN_VALUE
        Maximum integer is 2147483647, so the input 2147483648 is represented as -2147483648
        */
        while (n != 0) {
            /*
            // sol 1: bit AND with 1
            count += n & 1;
            // need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
            n = n >>> 1;
            */
            count++;
            // sol 2: bit AND with n - 1
            // n & (n - 1) drops the lowest set bit, 
            // e.g. if n = 00101100, then n - 1 = 00101011, so n & (n - 1) = 00101100 & 00101011 = 00101000.
            n = n & (n - 1);
        }
        return count;
    }
}