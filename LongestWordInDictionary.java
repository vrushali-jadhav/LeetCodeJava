/*Approach: 
Time Complexity: O(n*l) n= num of words, l=avg length of words
Space Complexity: O(n*l)

Use Trie. We build a trie with the words and perform a DFS. 
Using DFS will lead to removing the words that do not start with the desired word right in the beginning or as soon as it is encountered.
*/

class Solution {
    //TrieNode class to store characters
    class TrieNode{
        boolean isEnd;
        String currWord;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public Solution(){
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    //O(l)
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.currWord = word;
    }

    public String longestWord(String[] words) {
        for(String word: words){
            insert(word);
        }

        Queue<TrieNode> que = new LinkedList<>();
        que.add(root);
        TrieNode curr=root;
        while(!que.isEmpty()){
            curr = que.poll();
            for(int i=curr.children.length-1; i>=0; i--){
                if(curr.children[i]!=null && curr.children[i].isEnd){
                    que.add(curr.children[i]);
                }
            }
        }
        if(curr.currWord==null) return "";
        return curr.currWord;
    }
}