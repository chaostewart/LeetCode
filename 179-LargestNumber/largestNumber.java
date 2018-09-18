/*
the length of input array is n,
average length of Strings in strs is k => compare 2 strings will take O(k).
Sorting will take O(nlgn)
Appending to StringBuilder takes O(n).
So total will be O(knlogn) + O(n) = O(knlogn).

Space: O(n).
*/

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";

        // Convert int array to String array
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        // An extreme edge case where input is a bunch of 0s
        if(strs[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: strs)
            sb.append(s);

        return sb.toString();

    }
}