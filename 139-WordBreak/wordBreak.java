class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 1st Dynamic Programming problem!  Instantiate a DP array!
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;   // first elem acts like a dummy
        for (int i = 1; i <= s.length(); i++) {   
            for (String w: wordDict) {
                /* if in string s.substring(0, j) can be segamented into a space-separated sequence
                *                                         AND s.substring(j, i) is a word in given wordDict, 
                * then s.substring(0, i) can be segamented into a space-separated sequence, 
                *                                         which is indicated by flag[i]
                */
                int len = w.length();
                if (i >= len && flag[i - len] && s.substring(i - len, i).equals(w)) {  
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];   // flag[lastElement] is the answer  
    }
}
