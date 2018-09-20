class Solution {
    public boolean isPowerOfTwo(int n) {
        /*
        // this solution is not sleek but not slow either...
        if (n <= 0) 
            return false;
        if (n == 1)
            return true;
        if (n % 2 == 1)
            return false;
        return isPowerOfTwo(n/2);
        */
        
        // Power of 2 means only one bit of n is '1', e.g. 2 = 01, 4 = 10, 8 = 100, etc.
        // the trick is using bitwise AND '&', e.g 1001 & 0101 gives 0001
        return (n > 0) && (n & (n - 1)) == 0;
        
    }
}