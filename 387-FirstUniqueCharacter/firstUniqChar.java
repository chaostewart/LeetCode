class Solution {
    public int firstUniqChar(String s) {
        if (s.isEmpty()) return -1;
        // Snail sol1: no need to complicate the prob!
        /*
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) 
                map.put(c, s.length());
            else
                map.put(c, i);
        }
        int min = Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        return min == s.length() ? -1 : min;
        */
        
        // Rocket sol2: simple hash table
        int[] freq = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < s.length(); j++) {
            if (freq[s.charAt(j) - 'a'] == 1)
                return j;
        }
        return -1;
    }
}