class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 1st Dynamic Programming problem!  Instantiate a DP array!
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;   // first elem is like a dummy
        for (int i = 1; i <= s.length(); i++) {   
            for (int j = 0; j < i; j++) {
                /* if in string s.substring(0, j) can be segamented into a space-separated sequence
                *                                         AND s.substring(j, i) is a word in given wordDict, 
                * then s.substring(0, i) can be segamented into a space-separated sequence, 
                *                                         which is indicated by flag[i]
                */
                if (flag[j] && wordDict.contains(s.substring(j, i))) {  
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];   // flag[last elem] is the answer  
    }
}