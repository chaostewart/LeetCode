class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {  // special simple cases
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) { //two pointers would only move to the right
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);  // use Math.max here to avoid j rolling backwards
            }
            map.put(s.charAt(i), i);   // replace recurring char's value with the latest index
            max = Math.max(max, i - j + 1);  // substring's indces are continuous ints
            
        }
        return max;
    }
}