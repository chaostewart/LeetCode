class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {  // special simple cases
            return s.length();
        }
        // Map<char, char's last index in string>
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();       
        int res = 0;
        //create two pointers, i moves along the string, j points at the begining of a substring
        // both pointers move towards the same direction
        for (int i = 0, j = 0; i < s.length(); i++) { 
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);  // use Math.max here to avoid j rolling backwards
            }
            map.put(s.charAt(i), i);   // insert a new char or replace recurring char's value with the latest index
            res = Math.max(res, i - j + 1); 
        }
        return res;
    }
}
