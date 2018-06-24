class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);  // looking for a word now is O(1)
        if (!wordSet.contains(endWord)) return 0;  // endWord is not in wordList
        
        //Start bi-directional search
        Set<String> beginSet = new HashSet<>(),  endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int ans = 1;
        
        Set<String> visited = new HashSet<>(); // each round in the loop, only store newly visited nodes as a new "level"
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {  // both set are not empty, then there's still chance to meet 
            if (beginSet.size() > endSet.size()) {  // Swap to alway search the smaller set to improve efficiency
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }
            Set<String> newSet = new HashSet<>();
            for (String word: beginSet) {   // inspect each word in beginSet
                char[] chs = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {    // replace each char 26 times
                    char old = chs[i];   // store the orignal char then replace it back
                    for(char c = 'a'; c <= 'z'; c++) {
                        
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        
                        if (endSet.contains(target)) return ans + 1;  // begin & end sets meet here, found the shortest path
                        
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            newSet.add(target);
                            visited.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = newSet;  // newSet is like a new level of nodes searched
            ans++; // path length increase by one 
        }
        return 0; // this happens only when while loop conditions have failed, then two ends will never meet
    }
}