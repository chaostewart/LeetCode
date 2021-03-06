class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        // Sol1: sort the char array then compare
        /*
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);    // Java uses heapsort: O(nlogn) in time, O(1) in space
        Arrays.sort(tchar);
        return Arrays.equals(schar, tchar);   // use Arrays.equals() method instead of looping it yourself
        */
        
        // Sol2: Hash Table. Time: O(n), Space: O(1)
        int[] counter = new int[26];    // int array is intialized to default size with default value 0.
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;  
            counter[t.charAt(i) - 'a']--;
        }
        for (int j: counter)
            if (j != 0) return false;
        return true;
    }
}
