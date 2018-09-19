/*
At the very end of while loop, when left = mid = right.
In while, If mid < sqrt(x), left = mid + 1 executed, right pointer is not moving, and right is the answer. ??
In while, If mid > sqrt(x), right = mid - 1 executed, right pointer shifts left by 1, right is also the answer.
*/

class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) 
                return mid;
            else if (mid < x / mid) 
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return right;
    }
}