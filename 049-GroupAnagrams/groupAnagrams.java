class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) 
            return new ArrayList<List<String>>();   // don't forget the special case..
        Map<String, List<String>> map = new HashMap<>(); // Map a string (sorted charArray), to ArrayList<String>
        for (String s : strs) {  // exam each string in strs
            char[] chars = s.toCharArray();    // these 3 steps sort the chars in string s
            Arrays.sort(chars);
            String strKey = String.valueOf(chars);
            if (!map.containsKey(strKey))      // if it's the 1st appearance of an anagram
                map.put(strKey, new ArrayList<String>());   // creat a new string list for this group
            map.get(strKey).add(s);    // add string s (before sort)  to the list
        }
        return new ArrayList<List<String>>(map.values());    // map.values() return a collection of view of values...
    }
}
