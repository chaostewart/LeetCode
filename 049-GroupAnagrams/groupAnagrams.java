class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();  // Map a string (sorted charArray), to ArrayList<String>
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String tmp = String.valueOf(chs);
            if (!map.containsKey(tmp))
                map.put(tmp, new ArrayList<String>());
            map.get(tmp).add(s);
        }
        /*
        for (String s : map.keySet())
            res.add(map.get(s));
        return res;
        */
        return new ArrayList<>(map.values());    // map.values() return a collection of view of values...
    }
}
