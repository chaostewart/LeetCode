class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // slow sol1: Hash table
        /*
        int[] pcount = new int[26];
        for(char i: p.toCharArray()) {
            pcount[i - 'a']++;
        }
        for (int j = 0; j <= s.length() - p.length(); j++) {
            int[] jcount = new int[26];
            for (int k = 0; k < p.length(); k++) 
                jcount[s.charAt(j + k) - 'a']++;
            if (Arrays.equals(pcount, jcount)) 
                res.add(j);
        }
        return res;
        // fast sol2: Hash table with sliding window
        */
        if (s.isEmpty() || s.length() < p.length()) return res;
        int[] pcount = new int[26];
        for(char i: p.toCharArray()) {
            pcount[i - 'a']++;
        }
        int[] jcount = new int[26];
        // same idea but originally I used for loops instead. idices were confusing, run time was 20% slower
        // using two pointers 
        int left = 0, right = 0;
        while (right < s.length()) {
            while(right - left < p.length() - 1) {  // initialize the sliding window
                jcount[s.charAt(right) - 'a']++;
                right++;
            }            
            jcount[s.charAt(right) - 'a']++;
            if (Arrays.equals(pcount, jcount)) 
                res.add(left);
            jcount[s.charAt(left) - 'a']--;
            left++; right++;
        }
        return res;
    }
}