class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        // simple hash table
        int[] freq = new int[26]; 
        for (char c: s.toCharArray()) 
            freq[c - 'a']++;
        
        for (int j = 0; j < s.length(); j++) 
            if (freq[s.charAt(j) - 'a'] == 1)
                return j;
        
        return -1;
    }
}
