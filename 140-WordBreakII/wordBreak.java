class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, ArrayList<String>>());
    }
    
    // dfs function returns a list of all possible sentences derived from s.
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        
        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        
        for (String w1 : wordDict) 
            if (s.startsWith(w1)) {
                List<String> sublist = dfs(s.substring(w1.length()), wordDict, map);
                for (String w2 : sublist)
                    res.add(w1 + (w2.isEmpty() ? "" : " ") + w2);
            }
        
        map.put(s, res);
        return res;
        
    }
}