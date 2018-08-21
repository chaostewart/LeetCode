class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);  // looking for a word now is O(1)
        if (!wordSet.contains(endWord)) return 0;  // the case where endWord is not in wordList
        
        //Start bi-directional search
        Set<String> beginSet = new HashSet<>(),  endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int ans = 1;
        
        // Record visited words in wordList
        Set<String> visited = new HashSet<>(); 
        
        //while loop condition can be met when the two search ends still have chance to meet
        while (!beginSet.isEmpty() && !endSet.isEmpty()) { 
            if (beginSet.size() > endSet.size()) {  // Swap two sets to always search the smaller set
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }
            // in each loop, newly visited nodes are stored in newSet as a new "level", which will later replace beginSet
            Set<String> newSet = new HashSet<>(); 
            for (String word: beginSet) {   // inspect each word in beginSet
                char[] chs = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {    // for each word, replace each char 26 times
                    char old = chs[i];   // store the orignal char, later will replace it back
                    for(char c = 'a'; c <= 'z'; c++) {           
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        // if newly created word is in endSet, then begin & end sets meet here, shortest path is found
                        if (endSet.contains(target)) return ans + 1;  
                        // if target word is in wordList but hasn't been visited before, store it in visited set
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            newSet.add(target);
                            visited.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = newSet;  // newSet is a new level of nodes in the bi-directional search tree
            ans++; // path length increased by one 
        }
        return 0; // this happens only when while loop conditions cannot be met anymore, meaning two ends will never meet
    }
}
