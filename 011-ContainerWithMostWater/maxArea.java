/*
Start by evaluating the widest container, using the first and the last line. 
All other possible containers are less wide, so to hold more water, they need to be higher. 
Thus, after evaluating that widest container, skip lines at both ends that don't support a higher height. 
Then evaluate that new container we arrived at. Repeat until there are no more possible containers left.
*/

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int vol = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            vol = Math.max(vol, (j - i) * h);
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return vol;
    }
}