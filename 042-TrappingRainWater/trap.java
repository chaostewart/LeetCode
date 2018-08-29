class Solution {
    public int trap(int[] height) {       
        if ( height.length <= 2 ) return 0;      
        int l = 0, r = height.length - 1, ans = 0;   //set two pointers, move from both ends towards each other
        int leftMax = height[l], rightMax = height[r];   // the max height on both sides
        
        while ( l < r ) {    
            // fix the heigher bar, calculate water trapped on the lower bar side
            // if leftMax(left bar) is lower, move left pointer towards right until a higher left bar is found, update leftMax
            if ( height[l] < height[r] ) {     
                leftMax = Math.max(leftMax, height[++l]);
                ans += leftMax - height[l];
            // if rightMax(right bar) is lower, move right pointer towards left until a higher right bar is found, update rightMax
            } else {
                rightMax = Math.max(rightMax, height[--r]);
                ans += rightMax - height[r];
            } 
        }
        return ans;
    }
}