class WordDictionary {
    
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    private boolean search(TrieNode node, String word, int index) {
        if (index == word.length())
            return node.isWord;
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode n: node.children) 
                if (n != null && search(n, word, index + 1)) 
                    return true;
            return false;
        } else
            return node.children[c - 'a'] != null && search(node.children[c - 'a'], word, index + 1);
 
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
