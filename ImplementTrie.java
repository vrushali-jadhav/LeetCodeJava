class TrieNode{
    public TrieNode[] child; 
    public boolean isEnd;
    public TrieNode()
    {
        this.child = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie {
    /** Initialize your data structure here. */
    TrieNode root; 
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0; i<= word.length()-1; i++)
        {
            char c = word.charAt(i);
            if(temp.child[c - 'a']==null) //root doesn't have children
                temp.child[c - 'a'] = new TrieNode();
            temp = temp.child[c - 'a'];
        }
        temp.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0; i<= word.length()-1; i++)
        {
            char c = word.charAt(i);
            if(temp.child[c - 'a']==null)  
                return false; 
            temp = temp.child[c - 'a'];
        }
        return temp.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0; i<= prefix.length()-1; i++)
        {
            char c = prefix.charAt(i);
            if(temp.child[c - 'a']==null)  
                return false; 
            temp = temp.child[c - 'a'];
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