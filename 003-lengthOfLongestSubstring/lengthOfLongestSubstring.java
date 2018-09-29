class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int ans = 0;
        // Map<char, char's most recent position>
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        // create two pointers, end moves along the string, 
        // start points at the begining of the next substring
        // both pointers only move towards right
        while (end < s.length()) {
            char curr = s.charAt(end);
            if (map.containsKey(curr))
                start = Math.max(start, map.get(curr) + 1);
            map.put(curr, end);
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}
