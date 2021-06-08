/* Length of dictionary: m
Length of sentence: n 
Time complexity: building the hashset + going through the sentence = O(M+N)
Approach: 
1. Go through the dictionary and build a hashset. 
2. Traverese through the sentences char by char, as soon as the matching word is found in the dictionary, replace the whole word with the one in the dictionary. 
*/

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children; 
        public TrieNode()
        {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        public Trie()
        {
            this.root = new TrieNode();
        }
        
        public void insertWord(String word)
        {
            TrieNode temp = root;
            for(int i=0; i<= word.length()-1; i++)
            {
                char c = word.charAt(i);
                if(temp.children[c-'a']==null)
                    temp.children[c-'a'] = new TrieNode();
                temp = temp.children[c-'a'];
            }
            temp.isEnd = true; 
        }
        
        public boolean search(String word)
        {
            TrieNode temp = root;
            for(int i=0; i<= word.length()-1; i++)
            {
                char c = word.charAt(i);
                if(temp.children[c-'a']!=null)
                    temp = temp.children[c-'a'];
                else
                    return false;
            }
            return temp.isEnd; 
        }
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        StringBuilder result = new StringBuilder();
        for(String dict: dictionary)
        {
            trie.insertWord(dict);
        }
        
        //search the world in trie
        TrieNode temp = trie.root;
        StringBuilder currentWord = new StringBuilder();
        boolean foundShorterWord = false;
        for(int i=0; i<= sentence.length()-1; i++)
        {
            char c = sentence.charAt(i);
            if(c!=' ')
            {
                if(!foundShorterWord)
                {
                    currentWord.append(c);
                    if(trie.search(currentWord.toString()))
                        foundShorterWord = true;
                }
            }
            else
            {
                result.append(currentWord+" ");
                currentWord.setLength(0); //reset current string
                foundShorterWord = false;
            }
        }
        result.append(currentWord);
        return result.toString();
    }
}