class Trie {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    // this is a standard/typical approach for building out a Trie with its root having an empty character.
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    /* Loop through each character in the word being inserted check if the character is a child node of the current TrieNode i.e.       check if the array has a populated value in the index of this character.
    */
    public void insert(String word) {
        if (word.length() == 0) return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null)
                return false;
            curr = curr.children[word.charAt(i) - 'a'];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.children[prefix.charAt(i) - 'a'] == null) 
                return false;
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
